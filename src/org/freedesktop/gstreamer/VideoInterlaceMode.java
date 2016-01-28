package org.freedesktop.gstreamer;

public enum VideoInterlaceMode {
  /** all frames are progressive **/ 
  GST_VIDEO_INTERLACE_MODE_PROGRESSIVE,
  
  /** 2 fields are interleaved in one video frame. Extra buffer flags describe 
   * the field order.
   */ 
  GST_VIDEO_INTERLACE_MODE_INTERLEAVED,

  /** frames contains both interlaced and progressive video, the buffer flags 
   * describe the frame and fields.
   */
  GST_VIDEO_INTERLACE_MODE_MIXED,

  /** 2 fields are stored in one buffer, use the frame ID to get access to the 
   * required field. For multiview (the 'views' property > 1) the fields of view 
   * N can be found at frame ID (N * 2) and (N * 2) + 1. Each field has only
   * half the amount of lines as noted in the height property. 
   * This mode requires multiple GstVideoMeta metadata to describe the fields.
   */
  GST_VIDEO_INTERLACE_MODE_FIELDS;
}
