/*
 * Copyright (C) 2012 tamtam180
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package at.orz.hash;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * @author tamtam180 - kirscheless at gmail.com
 *
 */
public class XXHashTest {

	@Test
	public void test_fast32() throws Exception {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(XXHashTest.class.getResourceAsStream("/at/orz/hash/result_fast32_little.txt"), "utf-8"));
		
		String line;
		while ((line = input.readLine()) != null) {
			String[] items = line.split("\t");
			byte[] data = items[0].getBytes("utf-8");
			int seed = Integer.parseInt(items[1]);
			long result = Long.parseLong(items[2]);
			
			
			int hash = XXHash.digestFast32(data, seed, false);
			long uhash = EncodeUtils.toUnsigned(hash);
			
			assertThat(uhash, is(result));
		}
		
		input.close();
	}

	@Test
	public void test_strong32() throws Exception {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(XXHashTest.class.getResourceAsStream("/at/orz/hash/result_strong32_little.txt"), "utf-8"));
		
		String line;
		while ((line = input.readLine()) != null) {
			String[] items = line.split("\t");
			byte[] data = items[0].getBytes("utf-8");
			int seed = Integer.parseInt(items[1]);
			long result = Long.parseLong(items[2]);
			
			
			int hash = XXHash.digestStrong32(data, seed, false);
			long uhash = EncodeUtils.toUnsigned(hash);
			
			assertThat(uhash, is(result));
		}
		
		input.close();
	}

}
