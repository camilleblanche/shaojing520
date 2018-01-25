package com.camille.shaojing.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.camille.shaojing.constant.ShiroConstants;
import com.camille.shaojing.util.RedisUtils;

public class RedisSessionDao extends AbstractSessionDAO {
	@Autowired
	private RedisUtils redisUtils;
	
	private static final Logger LOG = LoggerFactory.getLogger(RedisSessionDao.class);
	@Override
	public void update(Session session) throws UnknownSessionException {
		if (session == null || session.getId() == null) {
			LOG.info("Session is null");
			return;
		}
		Serializable sessionId = session.getId();
		redisUtils.hSet(ShiroConstants.SHIRO_SESSION_KEY, sessionId.toString(), session);
	}

	@Override
	public void delete(Session session) {
		if (session == null || session.getId() == null) {
			LOG.info("Session is null");
			return;
		}
		redisUtils.hDel(ShiroConstants.SHIRO_SESSION_KEY, session.getId().toString());
	}

	@Override
	public Collection<Session> getActiveSessions() {
		List<Session> list = new ArrayList<>();
		List<Object> values = redisUtils.hVals(ShiroConstants.SHIRO_SESSION_KEY);
		for (Object object : values) {
			list.add((Session) object);
		}
		return list;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		// 添加进redis
		redisUtils.hSet(ShiroConstants.SHIRO_SESSION_KEY, sessionId.toString(), session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return (Session) redisUtils.hGet(ShiroConstants.SHIRO_SESSION_KEY, sessionId.toString());
	}

}
