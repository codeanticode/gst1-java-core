package org.freedesktop.gstreamer;

public enum VideoFrameFlags {
  /** no flags **/
  GST_VIDEO_FRAME_FLAG_NONE,
  
  /** The video frame is interlaced. In mixed interlace-mode, this flag 
   * specifies if the frame is interlaced or progressive.
   */
  GST_VIDEO_FRAME_FLAG_INTERLACED,
  
  /** The video frame has the top field first **/   
  GST_VIDEO_FRAME_FLAG_TFF,

  /** The video frame has the repeat flag **/ 
  GST_VIDEO_FRAME_FLAG_RFF,

  /** The video frame has one field **/ 
  GST_VIDEO_FRAME_FLAG_ONEFIELD,

  /** The video contains one or more non-mono views **/
  GST_VIDEO_FRAME_FLAG_MULTIPLE_VIEW,

  /** The video frame is the first in a set of corresponding views provided as 
   * sequential frames.
   */ 
  GST_VIDEO_FRAME_FLAG_FIRST_IN_BUNDLE;
}
