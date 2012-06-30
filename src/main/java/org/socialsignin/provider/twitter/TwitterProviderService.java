package org.socialsignin.provider.twitter;

import org.socialsignin.provider.AbstractProviderService;
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
		return new TwitterTemplate();
	}

}
