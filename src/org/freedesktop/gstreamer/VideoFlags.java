package org.freedesktop.gstreamer;

public enum VideoFlags {
  /** no flags **/
  GST_VIDEO_FLAG_NONE,
    
  /** a variable fps is selected, fps_n and fps_d denote the maximum fps of the video **/
  GST_VIDEO_FLAG_VARIABLE_FPS,
   
  /** Each color has been scaled by the alpha value. **/
  GST_VIDEO_FLAG_PREMULTIPLIED_ALPHA;   
}
