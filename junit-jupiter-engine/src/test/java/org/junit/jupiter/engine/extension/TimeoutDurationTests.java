/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.engine.extension;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TimeoutDurationTests {

	@Test
	void formatsDurationNicely() {
		assertThat(new TimeoutDuration(1, SECONDS)).hasToString("1 second");
		assertThat(new TimeoutDuration(2, SECONDS)).hasToString("2 seconds");
	}

}
