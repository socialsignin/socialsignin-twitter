/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.provider.twitter;

import org.socialsignin.provider.AbstractProviderConfig;
import org.socialsignin.springsocial.security.TwitterConnectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

/** 
* @author Michael Lavelle
*/
@Configuration
public class TwitterProviderConfig extends AbstractProviderConfig<Twitter> {

	@Autowired(required=false)
	private TwitterConnectInterceptor twitterConnectInterceptor;
	
	@Value("${twitter.consumerKey}")
	private String twitterConsumerKey;

	@Value("${twitter.consumerSecret}")
	private String twitterConsumerSecret;

	public TwitterProviderConfig() {
		super();
	}
	
	public TwitterConnectInterceptor getTwitterConnectInterceptor() {
		return twitterConnectInterceptor;
	}

	public String getTwitterConsumerKey() {
		return twitterConsumerKey;
	}

	public String getTwitterConsumerSecret() {
		return twitterConsumerSecret;
	}

	public TwitterProviderConfig(String twitterConsumerKey,String twitterConsumerSecret,
			Twitter authenticatedApi) {
		super(authenticatedApi);
		this.twitterConsumerKey = twitterConsumerKey;
		this.twitterConsumerSecret = twitterConsumerSecret;
	}
	
	public void setTwitterConsumerKey(String twitterConsumerKey) {
		this.twitterConsumerKey = twitterConsumerKey;
	}

	public void setTwitterConsumerSecret(String twitterConsumerSecret) {
		this.twitterConsumerSecret = twitterConsumerSecret;
	}

	
	public TwitterProviderConfig(String twitterConsumerKey,String twitterConsumerSecret,String accessToken,String accessTokenSecret) {
		super(new TwitterTemplate(twitterConsumerKey,twitterConsumerSecret,accessToken,accessTokenSecret));
		this.twitterConsumerKey = twitterConsumerKey;
		this.twitterConsumerSecret = twitterConsumerSecret;

	}
	
	public TwitterProviderConfig(String twitterConsumerKey,String twitterConsumerSecret,ConnectionRepository connectionRepository) {
		super(connectionRepository);
		this.twitterConsumerKey = twitterConsumerKey;
		this.twitterConsumerSecret = twitterConsumerSecret;
	}

	public TwitterProviderConfig(String twitterConsumerKey,String twitterConsumerSecret,ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository) {
		super(connectionRepository, usersConnectionRepository);
		this.twitterConsumerKey = twitterConsumerKey;
		this.twitterConsumerSecret = twitterConsumerSecret;
	}
	
	public TwitterProviderConfig(String twitterConsumerKey,String twitterConsumerSecret,String userId,	UsersConnectionRepository usersConnectionRepository,
			ConnectionFactoryRegistry connectionFactoryRegistry) {
		super(userId,usersConnectionRepository);
		this.twitterConsumerKey = twitterConsumerKey;
		this.twitterConsumerSecret = twitterConsumerSecret;

	}

	@Override
	protected ConnectInterceptor<Twitter> getConnectInterceptor() {
		return twitterConnectInterceptor;
	}

	@Override
	public Class<Twitter> getApiClass() {
		return Twitter.class;
	}

}
