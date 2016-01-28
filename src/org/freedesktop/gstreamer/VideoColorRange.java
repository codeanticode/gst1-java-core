package org.freedesktop.gstreamer;

// http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoColorRange
public enum VideoColorRange {
  GST_VIDEO_COLOR_RANGE_UNKNOWN,
  /** unknown range **/
   
  GST_VIDEO_COLOR_RANGE_0_255,
  /** [0..255] for 8 bit components **/
   
  GST_VIDEO_COLOR_RANGE_16_235;
  /** [16..235] for 8 bit components. Chroma has [16..240] range. **/
}
