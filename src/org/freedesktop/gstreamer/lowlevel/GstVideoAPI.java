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
import org.freedesktop.gstreamer.Caps;
import org.freedesktop.gstreamer.Pad;
import org.freedesktop.gstreamer.VideoChromaSite;
import org.freedesktop.gstreamer.VideoColorMatrix;
import org.freedesktop.gstreamer.VideoColorPrimaries;
import org.freedesktop.gstreamer.VideoColorRange;
import org.freedesktop.gstreamer.VideoFlags;
import org.freedesktop.gstreamer.VideoFormat;
import org.freedesktop.gstreamer.VideoFormatFlags;
import org.freedesktop.gstreamer.VideoFrameFlags;
import org.freedesktop.gstreamer.VideoInterlaceMode;
import org.freedesktop.gstreamer.VideoMultiviewFlags;
import org.freedesktop.gstreamer.VideoMultiviewMode;
import org.freedesktop.gstreamer.VideoTileMode;
import org.freedesktop.gstreamer.VideoTransferFunction;
import org.freedesktop.gstreamer.lowlevel.GValueAPI.GValue;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Union;

/*
 * http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html
 */
public interface GstVideoAPI extends Library {
	public final static GstVideoAPI GSTVIDEO_API = GstNative.load("gstvideo", GstVideoAPI.class);
	  static int GST_VIDEO_MAX_PLANES = 4;
	  static int GST_VIDEO_MAX_COMPONENTS = 4;
	  
    GValue gst_video_frame_rate(Pad pad);
    boolean gst_video_get_size(Pad pad, int [] width, int [] height);
    
    void gst_video_info_from_caps(VideoInfoStruct info, Caps caps);
    
    boolean gst_video_frame_map(VideoFrameStruct frame, VideoInfoStruct info,
                                Buffer buffer, int flags);
    void gst_video_frame_unmap(VideoFrameStruct frame);
    
    // http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoFormatInfo
    public static final class VideoFormatInfo extends com.sun.jna.Structure {
      public volatile int /*VideoFormat*/ format;
      public volatile Pointer/*String*/ name;
      public volatile Pointer/*String*/ description;
      public volatile int/*VideoFormatFlags*/ flags;
      public volatile int bits;
      public volatile int n_components;
      
      public volatile int[] shift = new int[GST_VIDEO_MAX_COMPONENTS];
      public volatile int[] depth = new int[GST_VIDEO_MAX_COMPONENTS];
      public volatile int[] pixel_stride = new int[GST_VIDEO_MAX_COMPONENTS];
      public volatile int n_planes;
      public volatile int[] plane = new int[GST_VIDEO_MAX_COMPONENTS];
      public volatile int[] poffset = new int[GST_VIDEO_MAX_COMPONENTS];
      public volatile int[] w_sub = new int[GST_VIDEO_MAX_COMPONENTS];
      public volatile int[] h_sub = new int[GST_VIDEO_MAX_COMPONENTS];

      public volatile int /*VideoFormat*/ unpack_format;
      public volatile Pointer unpack_func;
      public volatile int pack_lines;
      public volatile Pointer pack_func;

      public volatile int/*VideoTileMode*/ tile_mode;
      public volatile int tile_ws;
      public volatile int tile_hs;

      public volatile Pointer[] _gst_reserved = new Pointer[GstAPI.GST_PADDING];
      
      @Override
      protected List<String> getFieldOrder() {
        return Arrays.asList(new String[]{
          "format", "name", "description", "flags", "bits", "n_components", 
          "shift", "depth", "pixel_stride", "n_planes", "plane", "poffset",
          "w_sub", "h_sub",
          "unpack_format", "unpack_func", "pack_lines", "pack_func",
          "tile_mode", "tile_ws", "tile_hs", "_gst_reserved"
        });
      }
    }
    
   // http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoColorimetry
   public static final class GstVideoColorimetry extends com.sun.jna.Structure {
     public volatile VideoColorRange range;
     public volatile VideoColorMatrix matrix;
     public volatile VideoTransferFunction transfer;
     public volatile VideoColorPrimaries primaries;

      @Override
      protected List<String> getFieldOrder() {
        return Arrays.asList(new String[]{
          "range", "matrix", "transfer", "primaries"
        });
      }
    }
   
    public static final class VideoInfoAbi extends Union {      
      public volatile VideoMultiviewMode multiview_mode;
      public volatile VideoMultiviewFlags multiview_flags;
    }   
   
    // http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoInfo
    public static final class VideoInfoStruct extends com.sun.jna.Structure {
      public volatile VideoFormatInfo finfo;

      public volatile int /*VideoInterlaceMode*/ interlace_mode;
      public volatile int/*VideoFlags*/ flags;
      public volatile int width;
      public volatile int height;
      public volatile long size;
      public volatile int views;

      public volatile int /*VideoChromaSite*/ chroma_site;
      public volatile GstVideoColorimetry colorimetry;

      public volatile int par_n;
      public volatile int par_d;
      public volatile int fps_n;
      public volatile int fps_d;

      public volatile long[] offset = new long[GST_VIDEO_MAX_PLANES];
      public volatile int[] stride = new int[GST_VIDEO_MAX_COMPONENTS];

      public volatile VideoInfoAbi abi;
      
      @Override
      protected List<String> getFieldOrder() {
        return Arrays.asList(new String[]{
          "finfo", "interlace_mode", "flags", "width", "height", "size", "views",
          "chroma_site", "colorimetry", "par_n", "par_d", "fps_n", "fps_d",
          "offset", "stride", "abi"
        });
      }
    }

   
    // http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoFrame
    public static final class VideoFrameStruct extends com.sun.jna.Structure {
      public volatile VideoInfoStruct info;
      public volatile int /*VideoFrameFlags*/ flags; // maybe just int?

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
