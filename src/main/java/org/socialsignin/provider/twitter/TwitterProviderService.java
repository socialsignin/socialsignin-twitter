package org.socialsignin.provider.twitter;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

@Service
public class TwitterProviderService extends AbstractProviderService<Twitter> {

	@Override
	public Class<Twitter> getApiClass() {
		return Twitter.class;
	}

	@Override
	public Twitter getUnauthenticatedApi() {
		return new TwitterTemplate();
	}

}
