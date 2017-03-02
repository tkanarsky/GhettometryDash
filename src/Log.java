public class Log {
	public static final int QUIET = 0, ERRORS_ONLY = 1, NORMAL = 2, VERBOSE = 3;
	public static final int ERROR = 1, SHOWSTOPPER = 0;
	public static int LOG_STATE = QUIET;
	
	public static void log(String message, int importance) {
			if(importance <= LOG_STATE) {
				System.out.println(message);
			}
	}
	
	public static void error(String message) {
		if(1 <= LOG_STATE) {
			System.err.println("ERROR:" + message);
		}
	}
}
