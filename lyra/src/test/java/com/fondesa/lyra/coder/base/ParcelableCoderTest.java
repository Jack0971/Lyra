/*
 * Copyright (c) 2017 Fondesa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.lyra.coder.base;

import android.os.Parcelable;

import com.fondesa.lyra.common.TestModels;
import com.fondesa.lyra.sharedtest.BundleTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test class for {@link ParcelableCoder}.
 */
@RunWith(RobolectricTestRunner.class)
public class ParcelableCoderTest extends BundleTestCase {
    private ParcelableCoder mCoder = new ParcelableCoder();

    @Test
    public void testSerializeParcelable() {
        Parcelable expectedValue = TestModels.ImplementedParcelable.getDefault();
        mCoder.serialize(bundle(), randomKey(), expectedValue);
        assertEquals(expectedValue, bundle().getParcelable(randomKey()));
    }

    @Test
    public void testDeserializeParcelable() {
        Parcelable expectedValue = TestModels.ImplementedParcelable.getDefault();
        bundle().putParcelable(randomKey(), expectedValue);
        assertEquals(expectedValue, mCoder.deserialize(bundle(), randomKey()));
    }
}