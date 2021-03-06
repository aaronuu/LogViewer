package me.log.demo.processor;

import javax.websocket.Session;

import me.log.demo.AsyncQueueOutputStream;
import me.log.demo.WebLogger;
import me.log.demo.appender.WebLogManager;

/**
 * 重新开始指令的消息处理器
 * 
 * @author Long
 * @version 2014年5月11日
 * @author (lastest modification by Long)
 * @since 1.0
 */
public class ResumeMessageProcessor implements MessageProcessor {

	@Override
	public void process(Session session) {
		if (!AsyncQueueOutputStream.SESSION_QUEUE.contains(session))
			AsyncQueueOutputStream.SESSION_QUEUE.add(session);
	}


	@Override
	public void process(WebLogger webLogger) {
		webLogger.resume();
	}
}
