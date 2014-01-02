package org.ohmage.servlet;

import javax.servlet.http.HttpServletRequest;

import org.ohmage.domain.AuthorizationToken;
import org.ohmage.servlet.filter.AuthFilter;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * <p>
 * The root class for all Servlets.
 * </p>
 *
 * @author John Jenkins
 */
public abstract class OhmageServlet {
    /**
     * The attribute value for the request URL root.
     */
    protected static final String ATTRIBUTE_REQUEST_URL_ROOT =
        "request_url_root";

    /**
     * Retrieves the auth token from the request's attributes.
     *
     * @param request
     *        The HTTP request.
     *
     * @return The decoded {@link AuthorizationToken} from the request or null
     *         if no token was found.
     */
    @ModelAttribute(AuthFilter.ATTRIBUTE_AUTH_TOKEN)
    private AuthorizationToken getAuthToken(final HttpServletRequest request) {
        return
            (AuthorizationToken)
                request.getAttribute(AuthFilter.ATTRIBUTE_AUTH_TOKEN);
    }

    /**
     * Builds the request URL root. This is a URL that can be used as the basis
     * for subsequent redirect requests as it is built off of the current
     * request.
     *
     * @param request
     *        The current request.
     *
     * @return The request URL root of the form
     *         <tt>http[s]://{domain}[:{port}]{servlet_root_path}</tt>.
     */
    @ModelAttribute(ATTRIBUTE_REQUEST_URL_ROOT)
    protected String buildRequestUrlRoot(
        final HttpServletRequest httpRequest) {

        // It must be a HTTP request.
        StringBuilder builder = new StringBuilder("http");

        // If security was used add the "s" to make it "https".
        boolean secure = false;
        if(httpRequest.isSecure()) {
            secure = true;
            builder.append('s');
        }

        // Add the protocol separator.
        builder.append("://");

        // Add the name of the server where the request was sent.
        builder.append(httpRequest.getServerName());

        // Add the port separator and the port.
        int port = httpRequest.getServerPort();
        if(!
            ((! secure) && (port == 80)) ||
            (secure && (port == 443))) {

            builder.append(':').append(port);
        }

        // Add the context path, e.g. "/ohmage".
        builder.append(httpRequest.getContextPath());

        // Return the root URL.
        return builder.toString();
    }
}