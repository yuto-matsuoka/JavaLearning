package co.jp.beforward.ojt.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * メッセージUtility
 * @author shuhei sakaguchi
 *
 */
public class MessageUtil {
	/**
	 * メッセージプロパティファイルアクセス用
	 */
	@Autowired MessageSource messageSource;
	
	/**
	 * プロパティファイルからのメッセージ取得
	 * @param messageID
	 * 			メッセージのキー
	 * @return　メッセージ
	 */
	public String getMessage(String messageID) {
		return getMessage(messageID, (Object[]) null);
	}
	
	/**
	 * プロパティファイルからのメッセージ取得
	 * 
	 * @param messageID
	 * 			メッセージのキー
	 * @param args
	 * 			メッセージの埋め込み値
	 * @return　メッセージ
	 */
	public String getMessage(String messageID, Object... args) {
		return messageSource.getMessage(messageID, args, Locale.getDefault());
	}
}
