/*
 * Copyright (C) 2015 D10307009
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package tw.edu.sju.ee.eea.utils.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 * @author D10307009
 */
public class ChannelInputStream  extends ValueInputStream implements ValueOutput {

        private DataOutputStream pipe;

        public ChannelInputStream(int i) throws IOException {
            super(new PipedInputStream(i));
            pipe = new DataOutputStream(new PipedOutputStream((PipedInputStream) super.in));
        }

        public ChannelInputStream() throws IOException {
            this(1024000);
        }

        @Override
        public void writeValue(double value) throws IOException {
            pipe.writeDouble(value);
        }
    
}
