/*
 * SonarQube
 * Copyright (C) 2009-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.platform.web;

/**
 * An exception without any stacktrace nor message which point is solely to make tomcat startup fail during
 * initialization of the RulesDefinitionContext Listener {@link PlatformServletContextListener}.
 */
public class AbortTomcatStartException extends RuntimeException {
  public AbortTomcatStartException() {
    super("Aborting tomcat servlet context startup");
  }

  /**
   * Does not fill in the stack trace
   *
   * @see Throwable#fillInStackTrace()
   */
  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }

  @Override
  public String toString() {
    return getMessage();
  }
}
