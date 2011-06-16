/*******************************************************************************
 * Copyright 2011 The Regents of the University of California
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.ohmage.validator;

/**
 * Abstract base class for Validators which need to annotate an AwRequest as part of their processing.
 * 
 * @author selsky
 */
public abstract class AbstractAnnotatingValidator implements Validator {
	private AwRequestAnnotator _annotator;
	
	/**
	 * @throws IllegalArgumentException if the provided AnnotateAwRequestStrategy is null
	 */
	public AbstractAnnotatingValidator(AwRequestAnnotator annotator) {
		if(null == annotator) {
			throw new IllegalArgumentException("a non-null annotator is required");
		}
		
		_annotator = annotator;
	}
	
	protected AwRequestAnnotator getAnnotator() {
		return _annotator;
	}
}