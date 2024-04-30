package com.rocoplayer.app.util;

import java.text.DateFormat;
import java.util.Date;

/**
 * 类型转换工具
 */
public class Convert {
	/**
	 *
	 * 转型为整型
	 * @param obj 原始对象
	 * @param def 缺省值
	 * @return int
	 * @exception
	 * @since 1.0.0
	 */
	public static int to(Object obj, int def) {
		if (obj != null) {
			if (obj instanceof Number) {
				return ((Number) obj).intValue();
			} else if (obj instanceof Boolean) {
				return ((Boolean) obj).booleanValue() ? 1 : 0;
			} else if (obj instanceof Date) {
				return (int) ((Date) obj).getTime();
			} else {
				try {
					return Integer.parseInt(obj.toString());
				} catch (Exception e) {
					try {
						return (new Double(Double.parseDouble(obj.toString()))).intValue();
					} catch (Exception e2) {
						return def;
					}
				}
			}
		} else {
			return def;
		}
	}

	/**
	 *
	 * 转型为long
	 * @param obj 原始对象
	 * @param def 缺省值
	 * @return long
	 * @exception
	 * @since 1.0.0
	 */
	public static long to(Object obj, long def) {
		if (obj != null) {
			if (obj instanceof Number) {
				return ((Number) obj).longValue();
			} else if (obj instanceof Boolean) {
				return ((Boolean) obj).booleanValue() ? 1 : 0;
			} else if (obj instanceof Date) {
				return (int) ((Date) obj).getTime();
			} else {
				try {
					return Long.parseLong(obj.toString());
				} catch (Exception e) {
					try {
						return (new Long(Long.parseLong(obj.toString()))).longValue();
					} catch (Exception e2) {
						return def;
					}
				}
			}
		} else {
			return def;
		}
	}

	/**
	 *
	 * 转型为单精度浮点型
	 * @param obj 原始对象
	 * @param def 缺省值
	 * @return float
	 * @exception
	 * @since 1.0.0
	 */
	public static float to(Object obj, float def) {
		if (obj != null) {
			if (obj instanceof Float) {
				return ((Float) obj).floatValue();
			} else if (obj instanceof Float) {
				return ((Float) obj).floatValue();
			} else if (obj instanceof Integer) {
				return ((Integer) obj).intValue();
			} else if (obj instanceof Long) {
				return ((Long) obj).floatValue();
			} else if (obj instanceof Boolean) {
				return ((Boolean) obj).booleanValue() ? 1 : 0;
			} else if (obj instanceof Date) {
				return ((Date) obj).getTime();
			} else {
				try {
					return Float.parseFloat(obj.toString());
				} catch (Exception e) {
					return def;
				}
			}
		} else {
			return def;
		}
	}

	/**
	 *
	 * 转型为双精度浮点型
	 * @param obj 原始对象
	 * @param def 缺省值
	 * @return double
	 * @exception
	 * @since 1.0.0
	 */
	public static double to(Object obj, double def) {
		if (obj != null) {
			if (obj instanceof Double) {
				return ((Double) obj).doubleValue();
			} else if (obj instanceof Float) {
				return ((Float) obj).doubleValue();
			} else if (obj instanceof Integer) {
				return ((Integer) obj).intValue();
			} else if (obj instanceof Long) {
				return ((Long) obj).doubleValue();
			} else if (obj instanceof Boolean) {
				return ((Boolean) obj).booleanValue() ? 1 : 0;
			} else if (obj instanceof Date) {
				return ((Date) obj).getTime();
			} else {
				try {
					return Double.parseDouble(obj.toString());
				} catch (Exception e) {
					return def;
				}
			}
		} else {
			return def;
		}
	}

	/**
	 *
	 * 转型为布尔值
	 * @param obj 原始对象
	 * @param def 缺省值
	 * @return boolean
	 * @exception
	 * @since 1.0.0
	 */
	public static boolean to(Object obj, boolean def) {
		if (obj != null) {
			if (obj instanceof Boolean) {
				return ((Boolean) obj).booleanValue();
			} else if (obj instanceof Integer) {
				return ((Integer) obj).intValue() == 1;
			} else if (obj instanceof Long) {
				return ((Long) obj).longValue() == 1;
			} else if (obj instanceof Double) {
				return ((Double) obj).doubleValue() == 1;
			} else if (obj instanceof Date) {
				return ((Date) obj).getTime() == 1;
			} else {
				String str = obj.toString().toUpperCase();
				return str.equalsIgnoreCase("TRUE") || str.equalsIgnoreCase("YES") || str.equals("1");
			}
		} else {
			return def;
		}
	}

	/**
	 *
	 * 转型为字符串
	 * @param obj 原始对象
	 * @param def 缺省值
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String to(Object obj, String def) {
		if (obj != null) {
			return obj.toString();
		} else {
			return def;
		}
	}

	public static final boolean DEFAULT_BOOLEAN = false;

	public static final boolean[] DEFAULT_BOOLEAN_VALUES = new boolean[0];

	public static final double DEFAULT_DOUBLE = 0.0;

	public static final double[] DEFAULT_DOUBLE_VALUES = new double[0];

	public static final float DEFAULT_FLOAT = 0;

	public static final float[] DEFAULT_FLOAT_VALUES = new float[0];

	public static final int DEFAULT_INTEGER = 0;

	public static final int[] DEFAULT_INTEGER_VALUES = new int[0];

	public static final long DEFAULT_LONG = 0;

	public static final long[] DEFAULT_LONG_VALUES = new long[0];

	public static final short DEFAULT_SHORT = 0;

	public static final short[] DEFAULT_SHORT_VALUES = new short[0];

	public static String[] BOOLEANS = { "true", "t", "y", "on", "1" };

	public static boolean getBoolean(String value) {
		return getBoolean(value, DEFAULT_BOOLEAN);
	}

	public static boolean getBoolean(String value, boolean defaultValue) {
		return get(value, defaultValue);
	}

	public static boolean[] getBooleanValues(String[] values) {
		return getBooleanValues(values, DEFAULT_BOOLEAN_VALUES);
	}

	public static boolean[] getBooleanValues(String[] values, boolean[] defaultValue) {

		if (values == null) {
			return defaultValue;
		}

		boolean[] booleanValues = new boolean[values.length];

		for (int i = 0; i < values.length; i++) {
			booleanValues[i] = getBoolean(values[i]);
		}

		return booleanValues;
	}

	public static Date getDate(String value, DateFormat df) {
		return getDate(value, df, new Date());
	}

	public static Date getDate(String value, DateFormat df, Date defaultValue) {
		return get(value, df, defaultValue);
	}

	public static double getDouble(String value) {
		return getDouble(value, DEFAULT_DOUBLE);
	}

	public static double getDouble(String value, double defaultValue) {
		return get(value, defaultValue);
	}

	public static double[] getDoubleValues(String[] values) {
		return getDoubleValues(values, DEFAULT_DOUBLE_VALUES);
	}

	public static double[] getDoubleValues(String[] values, double[] defaultValue) {

		if (values == null) {
			return defaultValue;
		}

		double[] doubleValues = new double[values.length];

		for (int i = 0; i < values.length; i++) {
			doubleValues[i] = getDouble(values[i]);
		}

		return doubleValues;
	}

	public static float getFloat(String value) {
		return getFloat(value, DEFAULT_FLOAT);
	}

	public static float getFloat(String value, float defaultValue) {
		return get(value, defaultValue);
	}

	public static float[] getFloatValues(String[] values) {
		return getFloatValues(values, DEFAULT_FLOAT_VALUES);
	}

	public static float[] getFloatValues(String[] values, float[] defaultValue) {

		if (values == null) {
			return defaultValue;
		}

		float[] floatValues = new float[values.length];

		for (int i = 0; i < values.length; i++) {
			floatValues[i] = getFloat(values[i]);
		}

		return floatValues;
	}

	public static int getInteger(String value) {
		return getInteger(value, DEFAULT_INTEGER);
	}

	public static int getInteger(String value, int defaultValue) {
		return get(value, defaultValue);
	}

	public static int[] getIntegerValues(String[] values) {
		return getIntegerValues(values, DEFAULT_INTEGER_VALUES);
	}

	public static int[] getIntegerValues(String[] values, int[] defaultValue) {
		if (values == null) {
			return defaultValue;
		}

		int[] intValues = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			intValues[i] = getInteger(values[i]);
		}

		return intValues;
	}

	public static long getLong(String value) {
		return getLong(value, DEFAULT_LONG);
	}

	public static long getLong(String value, long defaultValue) {
		return get(value, defaultValue);
	}

	public static long[] getLongValues(String[] values) {
		return getLongValues(values, DEFAULT_LONG_VALUES);
	}

	public static long[] getLongValues(String[] values, long[] defaultValue) {
		if (values == null) {
			return defaultValue;
		}

		long[] longValues = new long[values.length];

		for (int i = 0; i < values.length; i++) {
			longValues[i] = getLong(values[i]);
		}

		return longValues;
	}

	public static short getShort(String value) {
		return getShort(value, DEFAULT_SHORT);
	}

	public static short getShort(String value, short defaultValue) {
		return get(value, defaultValue);
	}

	public static short[] getShortValues(String[] values) {
		return getShortValues(values, DEFAULT_SHORT_VALUES);
	}

	public static short[] getShortValues(String[] values, short[] defaultValue) {

		if (values == null) {
			return defaultValue;
		}

		short[] shortValues = new short[values.length];

		for (int i = 0; i < values.length; i++) {
			shortValues[i] = getShort(values[i]);
		}

		return shortValues;
	}

	public static String getString(String value, String defaultValue) {
		return get(value, defaultValue);
	}

	public static boolean get(String value, boolean defaultValue) {
		if (value != null) {
			try {
				value = value.trim();

				if (value.equalsIgnoreCase(BOOLEANS[0]) || value.equalsIgnoreCase(BOOLEANS[1])
						|| value.equalsIgnoreCase(BOOLEANS[2]) || value.equalsIgnoreCase(BOOLEANS[3])
						|| value.equalsIgnoreCase(BOOLEANS[4])) {

					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
			}
		}

		return defaultValue;
	}

	public static Date get(String value, DateFormat df, Date defaultValue) {
		try {
			Date date = df.parse(value.trim());

			if (date != null) {
				return date;
			}
		} catch (Exception e) {
		}

		return defaultValue;
	}

	public static double get(String value, double defaultValue) {
		try {
			return Double.parseDouble(_trim(value));
		} catch (Exception e) {
		}

		return defaultValue;
	}

	public static float get(String value, float defaultValue) {
		try {
			return Float.parseFloat(_trim(value));
		} catch (Exception e) {
		}

		return defaultValue;
	}

	public static int get(String value, int defaultValue) {
		try {
			return Integer.parseInt(_trim(value));
		} catch (Exception e) {
		}

		return defaultValue;
	}

	public static long get(String value, long defaultValue) {
		try {
			return Long.parseLong(_trim(value));
		} catch (Exception e) {
		}

		return defaultValue;
	}

	public static short get(String value, short defaultValue) {
		try {
			return Short.parseShort(_trim(value));
		} catch (Exception e) {
		}

		return defaultValue;
	}

	public static String get(String value, String defaultValue) {
		if (value != null) {
			value = value.trim();
			return value;
		}

		return defaultValue;
	}

	private static String _trim(String value) {
		if (value != null) {
			value = value.trim();

			StringBuffer sm = new StringBuffer();

			char[] charArray = value.toCharArray();

			for (int i = 0; i < charArray.length; i++) {
				if ((Character.isDigit(charArray[i])) || (charArray[i] == '-' && i == 0) || (charArray[i] == '.')) {

					sm.append(charArray[i]);
				}
			}

			value = sm.toString();
		}

		return value;
	}
}