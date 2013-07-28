package org.socialsignin.provider.twitter;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

@Service
public class TwitterProviderService extends AbstractProviderService<Twitter,TwitterProviderConfig> {

	public TwitterProviderService() {
		super();
	}

	public TwitterProviderService(TwitterProviderConfig providerConfig) {
		super(providerConfig);
	}

	@Override
	public Twitter getUnauthenticatedApi() {
		
		OAuth2Operations oauth2Operations = new OAuth2Template(providerConfig.getTwitterConsumerKey(),providerConfig.getTwitterConsumerSecret(),"","https://api.twitter.com/oauth2/token");
		AccessGrant accessGrant = oauth2Operations.authenticateClient(null);
		return new TwitterTemplate(accessGrant.getAccessToken());
		
	}

}
