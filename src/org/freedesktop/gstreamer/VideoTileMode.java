package org.freedesktop.gstreamer;

public enum VideoTileMode {
  /** Unknown or unset tile mode **/
  GST_VIDEO_TILE_MODE_UNKNOWN,
  
   /** Every four adjacent blocks - two horizontally and two vertically are 
    * grouped together and are located in memory in Z or flipped Z order. 
    * In case of odd rows, the last row of blocks is arranged in linear order. 
    */
  GST_VIDEO_TILE_MODE_ZFLIPZ_2X2;
  
}
