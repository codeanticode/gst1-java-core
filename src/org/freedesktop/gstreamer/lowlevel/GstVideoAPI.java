/* 
 * This file is part of gstreamer-java.
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * version 3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with this work.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.freedesktop.gstreamer.lowlevel;

import java.util.Arrays;
import java.util.List;

import org.freedesktop.gstreamer.Buffer;
import org.freedesktop.gstreamer.Pad;
import org.freedesktop.gstreamer.VideoFrameFlags;
import org.freedesktop.gstreamer.lowlevel.GValueAPI.GValue;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

public interface GstVideoAPI extends Library {
	public final static GstVideoAPI GSTVIDEO_API = GstNative.load("gstvideo", GstVideoAPI.class);
	  static int GST_VIDEO_MAX_PLANES = 4;
	
    GValue gst_video_frame_rate(Pad pad);
    boolean gst_video_get_size(Pad pad, int [] width, int [] height);
    boolean gst_video_frame_map(VideoFrameStruct frame, VideoInfoStruct info,
                                Buffer buffer, int flags);
    
    public static final class VideoInfoStruct extends com.sun.jna.Structure {

     
      
      /*    
      const GstVideoFormatInfo *finfo;

      GstVideoInterlaceMode     interlace_mode;
      GstVideoFlags             flags;
      public volatile int width;
      public volatile int height;
      gsize                     size;
      public volatile int views;

      GstVideoChromaSite        chroma_site;
      GstVideoColorimetry       colorimetry;

      public volatile int par_n;
      public volatile int par_d;
      public volatile int fps_n;
      public volatile int fps_d;

      gsize                     offset[GST_VIDEO_MAX_PLANES];
      gint                      stride[GST_VIDEO_MAX_PLANES];

      union {
        struct {
          GstVideoMultiviewMode     multiview_mode;
          GstVideoMultiviewFlags    multiview_flags;
        } abi;
        */

      
      @Override
      protected List<String> getFieldOrder() {
        return Arrays.asList(new String[]{
            "info", "flags", "buffer", "meta", "id", "data", "map"
        });
      }
        
    }

   
    public static final class VideoFrameStruct extends com.sun.jna.Structure {
      public volatile VideoInfoStruct info;
      public volatile VideoFrameFlags flags; // maybe just int?

      public volatile Buffer buffer;
      public volatile Pointer meta;
      public volatile int id;

      public volatile Pointer[] data = new Pointer[GST_VIDEO_MAX_PLANES];
      public volatile GstBufferAPI.MapInfoStruct[] map = new GstBufferAPI.MapInfoStruct[GST_VIDEO_MAX_PLANES];
      
      @Override
      protected List<String> getFieldOrder() {
        return Arrays.asList(new String[]{
            "info", "flags", "buffer", "meta", "id", "data", "map"
        });
      }
    }    
}
