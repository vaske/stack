/*******************************************************************************
 * Copyright (c) 2010, 2011 Ed Anuff and Usergrid, all rights reserved.
 * http://www.usergrid.com
 * 
 * This file is part of Usergrid Core.
 * 
 * Usergrid Core is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Usergrid Core is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Usergrid Core. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/edanuff/Development/java/antlr/QueryFilter.g 2011-07-27 19:20:21

package org.usergrid.persistence.query;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.apache.log4j.Logger;

public class QueryFilterLexer extends Lexer {
	public static final int EOF = -1;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__19 = 19;
	public static final int T__20 = 20;
	public static final int T__21 = 21;
	public static final int T__22 = 22;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int T__28 = 28;
	public static final int T__29 = 29;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int T__32 = 32;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int T__35 = 35;
	public static final int T__36 = 36;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int ID = 4;
	public static final int INT = 5;
	public static final int EXPONENT = 6;
	public static final int FLOAT = 7;
	public static final int ESC_SEQ = 8;
	public static final int STRING = 9;
	public static final int BOOLEAN = 10;
	public static final int HEX_DIGIT = 11;
	public static final int UUID = 12;
	public static final int UNICODE_ESC = 13;
	public static final int OCTAL_ESC = 14;
	public static final int WS = 15;

	private static final Logger logger = Logger
			.getLogger(QueryFilterLexer.class);

	@Override
	public void emitErrorMessage(String msg) {
		logger.info(msg);
	}

	// delegates
	// delegators

	public QueryFilterLexer() {
		;
	}

	public QueryFilterLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public QueryFilterLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	@Override
	public String getGrammarFileName() {
		return "/Users/edanuff/Development/java/antlr/QueryFilter.g";
	}

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:20:7: ( '<' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:20:9: '<'
			{
				match('<');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:21:7: ( '<='
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:21:9: '<='
			{
				match("<=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:22:7: ( '=' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:22:9: '='
			{
				match('=');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:23:7: ( '>' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:23:9: '>'
			{
				match('>');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:24:7: ( '>='
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:24:9: '>='
			{
				match(">=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:25:7: ( 'in'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:25:9: 'in'
			{
				match("in");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:26:7: ( 'eq'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:26:9: 'eq'
			{
				match("eq");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:27:7: ( 'lt'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:27:9: 'lt'
			{
				match("lt");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:28:7: ( 'gt'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:28:9: 'gt'
			{
				match("gt");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:29:7: ( 'lte'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:29:9: 'lte'
			{
				match("lte");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:30:7: ( 'gte'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:30:9: 'gte'
			{
				match("gte");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:31:7: (
			// 'contains' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:31:9:
			// 'contains'
			{
				match("contains");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:32:7: ( ',' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:32:9: ','
			{
				match(',');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:33:7: ( ':' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:33:9: ':'
			{
				match(':');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:34:7: ( 'asc'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:34:9: 'asc'
			{
				match("asc");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:35:7: (
			// 'desc' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:35:9: 'desc'
			{
				match("desc");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:36:7: ( '*' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:36:9: '*'
			{
				match('*');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:37:7: ( '{' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:37:9: '{'
			{
				match('{');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:38:7: ( '}' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:38:9: '}'
			{
				match('}');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:39:7: (
			// 'select' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:39:9:
			// 'select'
			{
				match("select");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:40:7: (
			// 'where' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:40:9: 'where'
			{
				match("where");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:41:7: ( 'and'
			// )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:41:9: 'and'
			{
				match("and");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:42:7: (
			// 'order by' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:42:9: 'order
			// by'
			{
				match("order by");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "T__38"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:43:5: ( ( 'a'
			// .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' ..
			// '9' | '_' | '.' )* )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:43:7: ( 'a'
			// .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' ..
			// '9' | '_' | '.' )*
			{
				if (((input.LA(1) >= 'A') && (input.LA(1) <= 'Z'))
						|| (input.LA(1) == '_')
						|| ((input.LA(1) >= 'a') && (input.LA(1) <= 'z'))) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:43:31: (
				// 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '.' )*
				loop1: do {
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if (((LA1_0 == '.') || ((LA1_0 >= '0') && (LA1_0 <= '9'))
							|| ((LA1_0 >= 'A') && (LA1_0 <= 'Z'))
							|| (LA1_0 == '_') || ((LA1_0 >= 'a') && (LA1_0 <= 'z')))) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:
					{
						if ((input.LA(1) == '.')
								|| ((input.LA(1) >= '0') && (input.LA(1) <= '9'))
								|| ((input.LA(1) >= 'A') && (input.LA(1) <= 'Z'))
								|| (input.LA(1) == '_')
								|| ((input.LA(1) >= 'a') && (input.LA(1) <= 'z'))) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop1;
					}
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:46:5: ( ( '0'
			// .. '9' )+ )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:46:7: ( '0'
			// .. '9' )+
			{
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:46:7: (
				// '0' .. '9' )+
				int cnt2 = 0;
				loop2: do {
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if ((((LA2_0 >= '0') && (LA2_0 <= '9')))) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:46:7:
						// '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt2 >= 1) {
							break loop2;
						}
						EarlyExitException eee = new EarlyExitException(2,
								input);
						throw eee;
					}
					cnt2++;
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INT"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:5: ( ( '0'
			// .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+
			// ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
			int alt9 = 3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
			case 1:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:9: (
				// '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
			{
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:9: (
				// '0' .. '9' )+
				int cnt3 = 0;
				loop3: do {
					int alt3 = 2;
					int LA3_0 = input.LA(1);

					if ((((LA3_0 >= '0') && (LA3_0 <= '9')))) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:10:
						// '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt3 >= 1) {
							break loop3;
						}
						EarlyExitException eee = new EarlyExitException(3,
								input);
						throw eee;
					}
					cnt3++;
				} while (true);

				match('.');
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:25: (
				// '0' .. '9' )*
				loop4: do {
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((((LA4_0 >= '0') && (LA4_0 <= '9')))) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:26:
						// '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						break loop4;
					}
				} while (true);

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:37: (
				// EXPONENT )?
				int alt5 = 2;
				int LA5_0 = input.LA(1);

				if (((LA5_0 == 'E') || (LA5_0 == 'e'))) {
					alt5 = 1;
				}
				switch (alt5) {
				case 1:
					// /Users/edanuff/Development/java/antlr/QueryFilter.g:50:37:
					// EXPONENT
				{
					mEXPONENT();

				}
					break;

				}

			}
				break;
			case 2:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:51:9: '.'
				// ( '0' .. '9' )+ ( EXPONENT )?
			{
				match('.');
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:51:13: (
				// '0' .. '9' )+
				int cnt6 = 0;
				loop6: do {
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if ((((LA6_0 >= '0') && (LA6_0 <= '9')))) {
						alt6 = 1;
					}

					switch (alt6) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:51:14:
						// '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt6 >= 1) {
							break loop6;
						}
						EarlyExitException eee = new EarlyExitException(6,
								input);
						throw eee;
					}
					cnt6++;
				} while (true);

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:51:25: (
				// EXPONENT )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);

				if (((LA7_0 == 'E') || (LA7_0 == 'e'))) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
					// /Users/edanuff/Development/java/antlr/QueryFilter.g:51:25:
					// EXPONENT
				{
					mEXPONENT();

				}
					break;

				}

			}
				break;
			case 3:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:52:9: (
				// '0' .. '9' )+ EXPONENT
			{
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:52:9: (
				// '0' .. '9' )+
				int cnt8 = 0;
				loop8: do {
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((((LA8_0 >= '0') && (LA8_0 <= '9')))) {
						alt8 = 1;
					}

					switch (alt8) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:52:10:
						// '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt8 >= 1) {
							break loop8;
						}
						EarlyExitException eee = new EarlyExitException(8,
								input);
						throw eee;
					}
					cnt8++;
				} while (true);

				mEXPONENT();

			}
				break;

			}
			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FLOAT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:56:5: ( '\\''
			// ( ESC_SEQ | ~ ( '\\\\' | '\\'' ) )* '\\'' )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:56:8: '\\'' (
			// ESC_SEQ | ~ ( '\\\\' | '\\'' ) )* '\\''
			{
				match('\'');
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:56:13: (
				// ESC_SEQ | ~ ( '\\\\' | '\\'' ) )*
				loop10: do {
					int alt10 = 3;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == '\\')) {
						alt10 = 1;
					} else if ((((LA10_0 >= '\u0000') && (LA10_0 <= '&'))
							|| ((LA10_0 >= '(') && (LA10_0 <= '[')) || ((LA10_0 >= ']') && (LA10_0 <= '\uFFFF')))) {
						alt10 = 2;
					}

					switch (alt10) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:56:15:
						// ESC_SEQ
					{
						mESC_SEQ();

					}
						break;
					case 2:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:56:25:
						// ~ ( '\\\\' | '\\'' )
					{
						if (((input.LA(1) >= '\u0000') && (input.LA(1) <= '&'))
								|| ((input.LA(1) >= '(') && (input.LA(1) <= '['))
								|| ((input.LA(1) >= ']') && (input.LA(1) <= '\uFFFF'))) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop10;
					}
				} while (true);

				match('\'');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "STRING"

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:60:9: ( (
			// 'true' | 'false' ) )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:60:11: (
			// 'true' | 'false' )
			{
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:60:11: (
				// 'true' | 'false' )
				int alt11 = 2;
				int LA11_0 = input.LA(1);

				if ((LA11_0 == 't')) {
					alt11 = 1;
				} else if ((LA11_0 == 'f')) {
					alt11 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("",
							11, 0, input);

					throw nvae;
				}
				switch (alt11) {
				case 1:
					// /Users/edanuff/Development/java/antlr/QueryFilter.g:60:12:
					// 'true'
				{
					match("true");

				}
					break;
				case 2:
					// /Users/edanuff/Development/java/antlr/QueryFilter.g:60:20:
					// 'false'
				{
					match("false");

				}
					break;

				}

			}

		} finally {
		}
	}

	// $ANTLR end "BOOLEAN"

	// $ANTLR start "UUID"
	public final void mUUID() throws RecognitionException {
		try {
			int _type = UUID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:62:6: (
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT '-' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// '-' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT '-' HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT '-' HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:62:8:
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT '-' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// '-' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT '-' HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT '-' HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			// HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				match('-');
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				match('-');
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				match('-');
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				match('-');
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "UUID"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:73:10: ( (
			// 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:73:12: ( 'e'
			// | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
				if ((input.LA(1) == 'E') || (input.LA(1) == 'e')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:73:22: (
				// '+' | '-' )?
				int alt12 = 2;
				int LA12_0 = input.LA(1);

				if (((LA12_0 == '+') || (LA12_0 == '-'))) {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
					// /Users/edanuff/Development/java/antlr/QueryFilter.g:
				{
					if ((input.LA(1) == '+') || (input.LA(1) == '-')) {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(
								null, input);
						recover(mse);
						throw mse;
					}

				}
					break;

				}

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:73:33: (
				// '0' .. '9' )+
				int cnt13 = 0;
				loop13: do {
					int alt13 = 2;
					int LA13_0 = input.LA(1);

					if ((((LA13_0 >= '0') && (LA13_0 <= '9')))) {
						alt13 = 1;
					}

					switch (alt13) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:73:34:
						// '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if (cnt13 >= 1) {
							break loop13;
						}
						EarlyExitException eee = new EarlyExitException(13,
								input);
						throw eee;
					}
					cnt13++;
				} while (true);

			}

		} finally {
		}
	}

	// $ANTLR end "EXPONENT"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:76:11: ( (
			// '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:76:13: ( '0'
			// .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			{
				if (((input.LA(1) >= '0') && (input.LA(1) <= '9'))
						|| ((input.LA(1) >= 'A') && (input.LA(1) <= 'F'))
						|| ((input.LA(1) >= 'a') && (input.LA(1) <= 'f'))) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:80:5: (
			// '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
			// | UNICODE_ESC | OCTAL_ESC )
			int alt14 = 3;
			int LA14_0 = input.LA(1);

			if ((LA14_0 == '\\')) {
				switch (input.LA(2)) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't': {
					alt14 = 1;
				}
					break;
				case 'u': {
					alt14 = 2;
				}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7': {
					alt14 = 3;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("",
							14, 1, input);

					throw nvae;
				}

			} else {
				NoViableAltException nvae = new NoViableAltException("", 14, 0,
						input);

				throw nvae;
			}
			switch (alt14) {
			case 1:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:80:9:
				// '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' |
				// '\\\\' )
			{
				match('\\');
				if ((input.LA(1) == '\"') || (input.LA(1) == '\'')
						|| (input.LA(1) == '\\') || (input.LA(1) == 'b')
						|| (input.LA(1) == 'f') || (input.LA(1) == 'n')
						|| (input.LA(1) == 'r') || (input.LA(1) == 't')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}
				break;
			case 2:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:81:9:
				// UNICODE_ESC
			{
				mUNICODE_ESC();

			}
				break;
			case 3:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:82:9:
				// OCTAL_ESC
			{
				mOCTAL_ESC();

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:5: (
			// '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' (
			// '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt15 = 3;
			int LA15_0 = input.LA(1);

			if ((LA15_0 == '\\')) {
				int LA15_1 = input.LA(2);

				if ((((LA15_1 >= '0') && (LA15_1 <= '3')))) {
					int LA15_2 = input.LA(3);

					if ((((LA15_2 >= '0') && (LA15_2 <= '7')))) {
						int LA15_4 = input.LA(4);

						if ((((LA15_4 >= '0') && (LA15_4 <= '7')))) {
							alt15 = 1;
						} else {
							alt15 = 2;
						}
					} else {
						alt15 = 3;
					}
				} else if ((((LA15_1 >= '4') && (LA15_1 <= '7')))) {
					int LA15_3 = input.LA(3);

					if ((((LA15_3 >= '0') && (LA15_3 <= '7')))) {
						alt15 = 2;
					} else {
						alt15 = 3;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException("",
							15, 1, input);

					throw nvae;
				}
			} else {
				NoViableAltException nvae = new NoViableAltException("", 15, 0,
						input);

				throw nvae;
			}
			switch (alt15) {
			case 1:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:9:
				// '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
			{
				match('\\');
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:14: (
				// '0' .. '3' )
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:15:
				// '0' .. '3'
				{
					matchRange('0', '3');

				}

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:25: (
				// '0' .. '7' )
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:26:
				// '0' .. '7'
				{
					matchRange('0', '7');

				}

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:36: (
				// '0' .. '7' )
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:87:37:
				// '0' .. '7'
				{
					matchRange('0', '7');

				}

			}
				break;
			case 2:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:88:9:
				// '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
			{
				match('\\');
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:88:14: (
				// '0' .. '7' )
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:88:15:
				// '0' .. '7'
				{
					matchRange('0', '7');

				}

				// /Users/edanuff/Development/java/antlr/QueryFilter.g:88:25: (
				// '0' .. '7' )
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:88:26:
				// '0' .. '7'
				{
					matchRange('0', '7');

				}

			}
				break;
			case 3:
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:89:9:
				// '\\\\' ( '0' .. '7' )
			{
				match('\\');
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:89:14: (
				// '0' .. '7' )
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:89:15:
				// '0' .. '7'
				{
					matchRange('0', '7');

				}

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:94:5: (
			// '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:94:9: '\\\\'
			// 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
				match('\\');
				match('u');
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();
				mHEX_DIGIT();

			}

		} finally {
		}
	}

	// $ANTLR end "UNICODE_ESC"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:97:4: ( ( ' '
			// | '\\t' | '\\n' | '\\r' | '\\f' )+ )
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:97:6: ( ' ' |
			// '\\t' | '\\n' | '\\r' | '\\f' )+
			{
				// /Users/edanuff/Development/java/antlr/QueryFilter.g:97:6: (
				// ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
				int cnt16 = 0;
				loop16: do {
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if ((((LA16_0 >= '\t') && (LA16_0 <= '\n'))
							|| ((LA16_0 >= '\f') && (LA16_0 <= '\r')) || (LA16_0 == ' '))) {
						alt16 = 1;
					}

					switch (alt16) {
					case 1:
						// /Users/edanuff/Development/java/antlr/QueryFilter.g:
					{
						if (((input.LA(1) >= '\t') && (input.LA(1) <= '\n'))
								|| ((input.LA(1) >= '\f') && (input.LA(1) <= '\r'))
								|| (input.LA(1) == ' ')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						if (cnt16 >= 1) {
							break loop16;
						}
						EarlyExitException eee = new EarlyExitException(16,
								input);
						throw eee;
					}
					cnt16++;
				} while (true);

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:8: ( T__16 |
		// T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25
		// | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 |
		// T__34 | T__35 | T__36 | T__37 | T__38 | ID | INT | FLOAT | STRING |
		// UUID | WS )
		int alt17 = 29;
		alt17 = dfa17.predict(input);
		switch (alt17) {
		case 1:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:10: T__16
		{
			mT__16();

		}
			break;
		case 2:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:16: T__17
		{
			mT__17();

		}
			break;
		case 3:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:22: T__18
		{
			mT__18();

		}
			break;
		case 4:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:28: T__19
		{
			mT__19();

		}
			break;
		case 5:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:34: T__20
		{
			mT__20();

		}
			break;
		case 6:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:40: T__21
		{
			mT__21();

		}
			break;
		case 7:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:46: T__22
		{
			mT__22();

		}
			break;
		case 8:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:52: T__23
		{
			mT__23();

		}
			break;
		case 9:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:58: T__24
		{
			mT__24();

		}
			break;
		case 10:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:64: T__25
		{
			mT__25();

		}
			break;
		case 11:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:70: T__26
		{
			mT__26();

		}
			break;
		case 12:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:76: T__27
		{
			mT__27();

		}
			break;
		case 13:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:82: T__28
		{
			mT__28();

		}
			break;
		case 14:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:88: T__29
		{
			mT__29();

		}
			break;
		case 15:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:94: T__30
		{
			mT__30();

		}
			break;
		case 16:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:100: T__31
		{
			mT__31();

		}
			break;
		case 17:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:106: T__32
		{
			mT__32();

		}
			break;
		case 18:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:112: T__33
		{
			mT__33();

		}
			break;
		case 19:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:118: T__34
		{
			mT__34();

		}
			break;
		case 20:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:124: T__35
		{
			mT__35();

		}
			break;
		case 21:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:130: T__36
		{
			mT__36();

		}
			break;
		case 22:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:136: T__37
		{
			mT__37();

		}
			break;
		case 23:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:142: T__38
		{
			mT__38();

		}
			break;
		case 24:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:148: ID
		{
			mID();

		}
			break;
		case 25:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:151: INT
		{
			mINT();

		}
			break;
		case 26:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:155: FLOAT
		{
			mFLOAT();

		}
			break;
		case 27:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:161: STRING
		{
			mSTRING();

		}
			break;
		case 28:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:168: UUID
		{
			mUUID();

		}
			break;
		case 29:
			// /Users/edanuff/Development/java/antlr/QueryFilter.g:1:173: WS
		{
			mWS();

		}
			break;

		}

	}

	protected DFA9 dfa9 = new DFA9(this);
	protected DFA17 dfa17 = new DFA17(this);
	static final String DFA9_eotS = "\5\uffff";
	static final String DFA9_eofS = "\5\uffff";
	static final String DFA9_minS = "\2\56\3\uffff";
	static final String DFA9_maxS = "\1\71\1\145\3\uffff";
	static final String DFA9_acceptS = "\2\uffff\1\2\1\1\1\3";
	static final String DFA9_specialS = "\5\uffff}>";
	static final String[] DFA9_transitionS = { "\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4", "", "", "" };

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			decisionNumber = 9;
			eot = DFA9_eot;
			eof = DFA9_eof;
			min = DFA9_min;
			max = DFA9_max;
			accept = DFA9_accept;
			special = DFA9_special;
			transition = DFA9_transition;
		}

		@Override
		public String getDescription() {
			return "49:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
		}
	}

	static final String DFA17_eotS = "\1\uffff\1\32\1\uffff\1\34\5\27\2\uffff\2\27\3\uffff\4\27\1\51\10"
			+ "\uffff\1\55\1\56\1\27\1\61\1\63\7\27\1\uffff\1\51\4\uffff\1\27\1"
			+ "\77\1\uffff\1\100\1\uffff\1\27\1\102\1\103\4\27\1\51\1\uffff\1\25"
			+ "\1\27\2\uffff\1\27\2\uffff\1\115\3\27\1\51\1\uffff\1\25\2\27\1\uffff"
			+ "\1\27\1\127\1\27\1\51\1\uffff\1\25\2\27\1\136\2\uffff\1\51\1\uffff"
			+ "\1\25\2\27\1\uffff\1\51\1\uffff\1\25\1\27\1\147\1\51\1\uffff\1\25"
			+ "\1\uffff\1\51\1\uffff\4\25";
	static final String DFA17_eofS = "\156\uffff";
	static final String DFA17_minS = "\1\11\1\75\1\uffff\1\75\1\156\1\60\2\164\1\60\2\uffff\2\60\3\uffff"
			+ "\1\145\1\150\1\162\1\60\1\56\10\uffff\2\56\1\60\2\56\1\156\1\143"
			+ "\1\144\1\60\1\154\1\145\1\144\1\uffff\1\56\1\53\3\uffff\1\60\1\56"
			+ "\1\uffff\1\56\1\uffff\1\164\2\56\1\143\1\145\1\162\1\145\1\56\1"
			+ "\53\2\60\2\uffff\1\141\2\uffff\1\56\1\143\1\145\1\162\1\56\1\53"
			+ "\2\60\1\151\1\uffff\1\164\1\56\1\40\1\56\1\53\2\60\1\156\1\56\2"
			+ "\uffff\1\56\1\53\2\60\1\163\1\uffff\1\56\1\53\1\60\1\55\1\56\1\55"
			+ "\1\53\1\55\1\uffff\1\56\4\60\1\55";
	static final String DFA17_maxS = "\1\175\1\75\1\uffff\1\75\1\156\1\161\2\164\1\157\2\uffff\1\163\1"
			+ "\146\3\uffff\1\145\1\150\1\162\2\146\10\uffff\2\172\1\146\2\172"
			+ "\1\156\1\143\1\144\1\163\1\154\1\145\1\144\1\uffff\2\146\3\uffff"
			+ "\1\146\1\172\1\uffff\1\172\1\uffff\1\164\2\172\1\143\1\145\1\162"
			+ "\1\145\4\146\2\uffff\1\141\2\uffff\1\172\1\143\1\145\1\162\4\146"
			+ "\1\151\1\uffff\1\164\1\172\1\40\4\146\1\156\1\172\2\uffff\4\146"
			+ "\1\163\1\uffff\3\146\1\55\1\172\1\145\1\71\1\55\1\uffff\1\145\4"
			+ "\146\1\55";
	static final String DFA17_acceptS = "\2\uffff\1\3\6\uffff\1\15\1\16\2\uffff\1\21\1\22\1\23\5\uffff\1"
			+ "\32\1\33\1\30\1\35\1\2\1\1\1\5\1\4\14\uffff\1\31\2\uffff\1\34\1"
			+ "\6\1\7\2\uffff\1\10\1\uffff\1\11\13\uffff\1\12\1\13\1\uffff\1\17"
			+ "\1\26\11\uffff\1\20\11\uffff\1\25\1\27\5\uffff\1\24\10\uffff\1\14"
			+ "\6\uffff";
	static final String DFA17_specialS = "\156\uffff}>";
	static final String[] DFA17_transitionS = {
			"\2\30\1\uffff\2\30\22\uffff\1\30\6\uffff\1\26\2\uffff\1\15\1"
					+ "\uffff\1\11\1\uffff\1\25\1\uffff\12\24\1\12\1\uffff\1\1\1\2"
					+ "\1\3\2\uffff\6\23\24\27\4\uffff\1\27\1\uffff\1\13\1\23\1\10"
					+ "\1\14\1\5\1\23\1\7\1\27\1\4\2\27\1\6\2\27\1\22\3\27\1\20\3\27"
					+ "\1\21\3\27\1\16\1\uffff\1\17",
			"\1\31",
			"",
			"\1\33",
			"\1\35",
			"\12\37\7\uffff\6\37\32\uffff\6\37\12\uffff\1\36",
			"\1\40",
			"\1\41",
			"\12\37\7\uffff\6\37\32\uffff\6\37\10\uffff\1\42",
			"",
			"",
			"\12\37\7\uffff\6\37\32\uffff\6\37\7\uffff\1\44\4\uffff\1\43",
			"\12\37\7\uffff\6\37\32\uffff\4\37\1\45\1\37",
			"",
			"",
			"",
			"\1\46",
			"\1\47",
			"\1\50",
			"\12\37\7\uffff\6\37\32\uffff\6\37",
			"\1\25\1\uffff\12\52\7\uffff\4\54\1\53\1\54\32\uffff\4\54\1"
					+ "\53\1\54",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\12\57\7\uffff\6\57\32\uffff\6\57",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"
					+ "\1\60\25\27",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\4\27"
					+ "\1\62\25\27",
			"\1\64",
			"\1\65",
			"\1\66",
			"\12\57\7\uffff\6\57\32\uffff\6\57\14\uffff\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"",
			"\1\25\1\uffff\12\73\7\uffff\4\54\1\74\1\54\32\uffff\4\54\1"
					+ "\74\1\54",
			"\1\25\1\uffff\1\25\2\uffff\12\75\7\uffff\6\54\32\uffff\6\54",
			"",
			"",
			"",
			"\12\76\7\uffff\6\76\32\uffff\6\76",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\1\101",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\25\1\uffff\12\110\7\uffff\4\54\1\111\1\54\32\uffff\4\54"
					+ "\1\111\1\54",
			"\1\25\1\uffff\1\25\2\uffff\12\112\7\uffff\6\54\32\uffff\6\54",
			"\12\112\7\uffff\6\54\32\uffff\6\54",
			"\12\113\7\uffff\6\113\32\uffff\6\113",
			"",
			"",
			"\1\114",
			"",
			"",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\25\1\uffff\12\121\7\uffff\4\54\1\122\1\54\32\uffff\4\54"
					+ "\1\122\1\54",
			"\1\25\1\uffff\1\25\2\uffff\12\123\7\uffff\6\54\32\uffff\6\54",
			"\12\123\7\uffff\6\54\32\uffff\6\54",
			"\12\124\7\uffff\6\124\32\uffff\6\124",
			"\1\125",
			"",
			"\1\126",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\130",
			"\1\25\1\uffff\12\131\7\uffff\4\54\1\132\1\54\32\uffff\4\54"
					+ "\1\132\1\54",
			"\1\25\1\uffff\1\25\2\uffff\12\133\7\uffff\6\54\32\uffff\6\54",
			"\12\133\7\uffff\6\54\32\uffff\6\54",
			"\12\134\7\uffff\6\134\32\uffff\6\134",
			"\1\135",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"",
			"\1\25\1\uffff\12\137\7\uffff\4\54\1\140\1\54\32\uffff\4\54"
					+ "\1\140\1\54",
			"\1\25\1\uffff\1\25\2\uffff\12\141\7\uffff\6\54\32\uffff\6\54",
			"\12\141\7\uffff\6\54\32\uffff\6\54",
			"\12\142\7\uffff\6\142\32\uffff\6\142",
			"\1\143",
			"",
			"\1\25\1\uffff\12\144\7\uffff\4\54\1\145\1\54\32\uffff\4\54"
					+ "\1\145\1\54",
			"\1\25\1\uffff\1\25\2\uffff\12\146\7\uffff\6\54\32\uffff\6\54",
			"\12\146\7\uffff\6\54\32\uffff\6\54", "\1\54",
			"\1\27\1\uffff\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\54\1\25\1\uffff\12\150\13\uffff\1\25\37\uffff\1\25",
			"\1\25\1\uffff\1\151\2\uffff\12\25", "\1\54", "",
			"\1\25\1\uffff\12\150\13\uffff\1\25\37\uffff\1\25",
			"\12\152\7\uffff\6\54\32\uffff\6\54",
			"\12\153\7\uffff\6\54\32\uffff\6\54",
			"\12\154\7\uffff\6\54\32\uffff\6\54",
			"\12\155\7\uffff\6\54\32\uffff\6\54", "\1\54" };

	static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
	static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
	static final char[] DFA17_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA17_minS);
	static final char[] DFA17_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA17_maxS);
	static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
	static final short[] DFA17_special = DFA
			.unpackEncodedString(DFA17_specialS);
	static final short[][] DFA17_transition;

	static {
		int numStates = DFA17_transitionS.length;
		DFA17_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
		}
	}

	class DFA17 extends DFA {

		public DFA17(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			decisionNumber = 17;
			eot = DFA17_eot;
			eof = DFA17_eof;
			min = DFA17_min;
			max = DFA17_max;
			accept = DFA17_accept;
			special = DFA17_special;
			transition = DFA17_transition;
		}

		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | ID | INT | FLOAT | STRING | UUID | WS );";
		}
	}

}
