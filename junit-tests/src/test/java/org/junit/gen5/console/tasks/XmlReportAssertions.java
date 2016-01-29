/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.console.tasks;

import java.io.StringReader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.opentest4j.AssertionFailedError;
import org.xml.sax.SAXException;

public class XmlReportAssertions {

	private static Validator schemaValidator;

	static String ensureValidAccordingToJenkinsSchema(String content) throws Exception {
		try {
			getSchemaValidator().validate(new StreamSource(new StringReader(content)));
			return content;
		}
		catch (SAXException e) {
			throw new AssertionFailedError("Invalid XML document: " + content, e);
		}
	}

	private static Validator getSchemaValidator() throws SAXException {
		if (schemaValidator == null) {
			URL schemaFile = XmlReportsWritingListener.class.getResource("/jenkins-junit.xsd");
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			schemaValidator = schemaFactory.newSchema(schemaFile).newValidator();
		}
		return schemaValidator;
	}
}
