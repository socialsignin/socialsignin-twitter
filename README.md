<a href="https://github.com/socialsignin/socialsignin-provider">SocialSignin Provider</a> Module for <a href="https://github.com/SpringSource/spring-social-twitter">Spring-Social-Twitter</a>
======================================================

Add this module to your classpath and component scan to auto-register and configure spring-social-twitter for your
application.
```
    <context:component-scan
                base-package="org.socialsignin.provider" />
```

Requires Spring Social's ConnectionFactoryRegistry, a UsersConnectionRepository and a ConnectionRepository (associated with the authenticated user) to exist as beans in your application context.

When using the default component scan to register this Twitter module, the following properties must be set in your application:

Module Features

- Auto-configuration and registration of TwitterConnectionFactory based on properties in your environment
- Registers a TwitterProviderService bean - this component can be injected into your application's services and provides
access to Twitter API Client directly for common use cases, reducing need for developers to interact with low-level connections.
- If Spring-Social-Security is used, the TwitterConnectInterceptor required by Spring-Social-Security will 
automatically be registered with the ConnectInterceptorList for easy injection into ConnectController.
- Quickstart implementations of UsersConnectionRepostory/ConnectionRepository to help developers get up and running
using Spring-Social without needing to set up databases in the first instance.
