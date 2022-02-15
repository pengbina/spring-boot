/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * Enable auto-configuration of the Spring Application Context, attempting to guess and
 * configure beans that you are likely to need. Auto-configuration classes are usually
 * applied based on your classpath and what beans you have defined. For example, if you
 * have {@code tomcat-embedded.jar} on your classpath you are likely to want a
 * {@link TomcatServletWebServerFactory} (unless you have defined your own
 * {@link ServletWebServerFactory} bean).
 * <p>
 * When using {@link SpringBootApplication @SpringBootApplication}, the auto-configuration
 * of the context is automatically enabled and adding this annotation has therefore no
 * additional effect.
 * <p>
 * Auto-configuration tries to be as intelligent as possible and will back-away as you
 * define more of your own configuration. You can always manually {@link #exclude()} any
 * configuration that you never want to apply (use {@link #excludeName()} if you don't
 * have access to them). You can also exclude them via the
 * {@code spring.autoconfigure.exclude} property. Auto-configuration is always applied
 * after user-defined beans have been registered.
 * <p>
 * The package of the class that is annotated with {@code @EnableAutoConfiguration},
 * usually via {@code @SpringBootApplication}, has specific significance and is often used
 * as a 'default'. For example, it will be used when scanning for {@code @Entity} classes.
 * It is generally recommended that you place {@code @EnableAutoConfiguration} (if you're
 * not using {@code @SpringBootApplication}) in a root package so that all sub-packages
 * and classes can be searched.
 * <p>
 * Auto-configuration classes are regular Spring {@link Configuration @Configuration}
 * beans. They are located using the {@link SpringFactoriesLoader} mechanism (keyed
 * against this class). Generally auto-configuration beans are
 * {@link Conditional @Conditional} beans (most often using
 * {@link ConditionalOnClass @ConditionalOnClass} and
 * {@link ConditionalOnMissingBean @ConditionalOnMissingBean} annotations).
 *
 * @author Phillip Webb
 * @author Stephane Nicoll
 * @since 1.0.0
 * @see ConditionalOnBean
 * @see ConditionalOnMissingBean
 * @see ConditionalOnClass
 * @see AutoConfigureAfter
 * @see SpringBootApplication
 *
 * 自动配置中使用的条件化注解
 *
 * @ConditionalOnBean 配置了某个特定Bean
 * @ConditionalOnMissingBean 没有配置特定的Bean
 * @ConditionOnClass   Classpath里有指定的类
 * @ConditionOnMissingClass  Classpath里缺少指定的类
 * @ConditionOnExpression   给定的Spring Expression Language (SpEL)表达式计算结果为True
 * @ConditionOnJava      Java的版本匹配特定值或者一个范围值
 * @ConditionOnJndi      参数中给定的JNDI位置必须存在一个，如果没有给参数，则要有JNDI InitialContext
 * @ConditionOnProperty  指定的配置属性要有一个明确的值
 * @ConditionOnResource  Classpath里有指定的资源
 * @ConditionOnWebApplication  这是一个Web应用程序
 * @ConditionOnNotWebApplication  这不是一个Web应用程序
 *
 *
 * Actuator开发接口
 *
 * HTTP方法                    路径                        描述
 * GET                        /autoconfig                 提供了一份自动配置报告，记录哪些自动配置条件通过了，哪些没通过
 * GET                        /configprops                描述配置属性(包含默认值)如何注入Bean
 * GET                        /beans                      描述应用程序上下文里全部的Bean，以及它们的关系
 * GET                        /dump                       获取线程活动的快照
 * GET                        /env                        获取全部环境属性
 * GET                        /env/{name}                 根据名称获取特定的环境属性值
 * GET                        /health                     报告应用程序的健康指标，这些值由HealthIndicator的实现类提供
 * GET                        /info                       获取应用程序的定制信息，这些信息由info打头的属性提供
 * GET                        /mappings                   描述全部的URI路径，以及它们和控制器(包含Actuator端点）的映射关系
 * GET                        /metrics                    报告各种应用程序度量信息，比如内存用量和HTTP请求计数
 * GET                        /metrics/{name}             报告指定名称的应用程序度量值
 * POST                       /shutdown                   关闭应用程序，要求endpoints.shutdown.enabled设置为true
 * GET                        /trace                      提供基本的HTTP请求跟踪信息(时间戳，HTTP头等)
 *
 * 自动配置包注解 @AutoConfigurationPackage
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {

	/**
	 * Environment property that can be used to override when auto-configuration is
	 * enabled.
	 */
	String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

	/**
	 * Exclude specific auto-configuration classes such that they will never be applied.
	 * @return the classes to exclude
	 */
	Class<?>[] exclude() default {};

	/**
	 * Exclude specific auto-configuration class names such that they will never be
	 * applied.
	 * @return the class names to exclude
	 * @since 1.3.0
	 */
	String[] excludeName() default {};

}
