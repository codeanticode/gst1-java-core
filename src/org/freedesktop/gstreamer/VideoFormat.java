package org.freedesktop.gstreamer;

public enum VideoFormat {
  /** Unknown or unset video format id **/
  GST_VIDEO_FORMAT_UNKNOWN,
  
  /** Encoded video format. Only ever use that in caps for special video 
   * formats in combination with non-system memory GstCapsFeatures where it 
   * does not make sense to specify a real video format. 
   */
  GST_VIDEO_FORMAT_ENCODED,
    
  /** planar 4:2:0 YUV **/
  GST_VIDEO_FORMAT_I420,
  
  /** planar 4:2:0 YVU (like I420 but UV planes swapped) **/ 
  GST_VIDEO_FORMAT_YV12,
  
  /** packed 4:2:2 YUV (Y0-U0-Y1-V0 Y2-U2-Y3-V2 Y4 ...) **/
  GST_VIDEO_FORMAT_YUY2,
  
  /** packed 4:2:2 YUV (U0-Y0-V0-Y1 U2-Y2-V2-Y3 U4 ...) **/ 
  GST_VIDEO_FORMAT_UYVY,
  
  /** packed 4:4:4 YUV with alpha channel (A0-Y0-U0-V0 ...) **/   
  GST_VIDEO_FORMAT_AYUV,

  /** sparse rgb packed into 32 bit, space last **/   
  GST_VIDEO_FORMAT_RGBx,

  /** sparse reverse rgb packed into 32 bit, space last **/   
  GST_VIDEO_FORMAT_BGRx,

   
  GST_VIDEO_FORMAT_xRGB,
  /** sparse rgb packed into 32 bit, space first **/

  /** sparse reverse rgb packed into 32 bit, space first **/  
  GST_VIDEO_FORMAT_xBGR,

  /** rgb with alpha channel last **/   
  GST_VIDEO_FORMAT_RGBA,

  /** reverse rgb with alpha channel last **/   
  GST_VIDEO_FORMAT_BGRA,

  /** rgb with alpha channel first **/  
  GST_VIDEO_FORMAT_ARGB,
  
  /** reverse rgb with alpha channel first **/   
  GST_VIDEO_FORMAT_ABGR,

  /** rgb **/   
  GST_VIDEO_FORMAT_RGB,

  /** reverse rgb **/   
  GST_VIDEO_FORMAT_BGR,

  /** planar 4:1:1 YUV **/   
  GST_VIDEO_FORMAT_Y41B,

  /** planar 4:2:2 YUV **/   
  GST_VIDEO_FORMAT_Y42B,

  /** packed 4:2:2 YUV (Y0-V0-Y1-U0 Y2-V2-Y3-U2 Y4 ...) **/   
  GST_VIDEO_FORMAT_YVYU,

  /** planar 4:4:4 YUV **/   
  GST_VIDEO_FORMAT_Y444,

  /** packed 4:2:2 10-bit YUV, complex format **/   
  GST_VIDEO_FORMAT_v210,

  /** packed 4:2:2 16-bit YUV, Y0-U0-Y1-V1 order **/   
  GST_VIDEO_FORMAT_v216,

  /** planar 4:2:0 YUV with interleaved UV plane **/   
  GST_VIDEO_FORMAT_NV12,

  /** planar 4:2:0 YUV with interleaved VU plane **/   
  GST_VIDEO_FORMAT_NV21,

  /** 8-bit grayscale **/   
  GST_VIDEO_FORMAT_GRAY8,

  /** 16-bit grayscale, most significant byte first **/   
  GST_VIDEO_FORMAT_GRAY16_BE,

  /** 16-bit grayscale, least significant byte first **/   
  GST_VIDEO_FORMAT_GRAY16_LE,

  /** packed 4:4:4 YUV **/   
  GST_VIDEO_FORMAT_v308,

  /** rgb 5-6-5 bits per component **/   
  GST_VIDEO_FORMAT_RGB16,

  /** reverse rgb 5-6-5 bits per component **/   
  GST_VIDEO_FORMAT_BGR16,

  /** rgb 5-5-5 bits per component **/   
  GST_VIDEO_FORMAT_RGB15,

  /** reverse rgb 5-5-5 bits per component **/   
  GST_VIDEO_FORMAT_BGR15,

  /** packed 10-bit 4:2:2 YUV (U0-Y0-V0-Y1 U2-Y2-V2-Y3 U4 ...) **/   
  GST_VIDEO_FORMAT_UYVP,

  /** planar 4:4:2:0 AYUV **/   
  GST_VIDEO_FORMAT_A420,

  /** 8-bit paletted RGB **/   
  GST_VIDEO_FORMAT_RGB8P,

  /** planar 4:1:0 YUV **/   
  GST_VIDEO_FORMAT_YUV9,

  /** planar 4:1:0 YUV (like YUV9 but UV planes swapped) **/ 
  GST_VIDEO_FORMAT_YVU9,
  
  /** packed 4:1:1 YUV (Cb-Y0-Y1-Cr-Y2-Y3 ...) **/   
  GST_VIDEO_FORMAT_IYU1,

  /** rgb with alpha channel first, 16 bits per channel **/   
  GST_VIDEO_FORMAT_ARGB64,

  /** packed 4:4:4 YUV with alpha channel, 16 bits per channel (A0-Y0-U0-V0 ...) **/ 
  GST_VIDEO_FORMAT_AYUV64,
  
  /** packed 4:4:4 RGB, 10 bits per channel **/   
  GST_VIDEO_FORMAT_r210,

  /** planar 4:2:0 YUV, 10 bits per channel **/   
  GST_VIDEO_FORMAT_I420_10BE,

  /** planar 4:2:0 YUV, 10 bits per channel **/   
  GST_VIDEO_FORMAT_I420_10LE,

  /** planar 4:2:2 YUV, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_I422_10BE,
  
  /** planar 4:2:2 YUV, 10 bits per channel **/   
  GST_VIDEO_FORMAT_I422_10LE,

  /** planar 4:4:4 YUV, 10 bits per channel **/   
  GST_VIDEO_FORMAT_Y444_10BE,

  /** planar 4:4:4 YUV, 10 bits per channel **/   
  GST_VIDEO_FORMAT_Y444_10LE,

  /** planar 4:4:4 RGB, 8 bits per channel **/   
  GST_VIDEO_FORMAT_GBR,

  /** planar 4:4:4 RGB, 10 bits per channel **/   
  GST_VIDEO_FORMAT_GBR_10BE,

  /** planar 4:4:4 RGB, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_GBR_10LE,
  
  /** planar 4:2:2 YUV with interleaved UV plane **/ 
  GST_VIDEO_FORMAT_NV16,
  
  /** planar 4:4:4 YUV with interleaved UV plane **/ 
  GST_VIDEO_FORMAT_NV24,
  
  /** NV12 with 64x32 tiling in zigzag pattern **/ 
  GST_VIDEO_FORMAT_NV12_64Z32,
  
  /** planar 4:4:2:0 YUV, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_A420_10BE,
  
  /** planar 4:4:2:0 YUV, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_A420_10LE,
  
  /** planar 4:4:2:2 YUV, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_A422_10BE,
  
  /** planar 4:4:2:2 YUV, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_A422_10LE,
  
  /** planar 4:4:4:4 YUV, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_A444_10BE,
  
  /** planar 4:4:4:4 YUV, 10 bits per channel **/ 
  GST_VIDEO_FORMAT_A444_10LE,
  
  /** planar 4:2:2 YUV with interleaved VU plane (Since 1.6) **/ 
  GST_VIDEO_FORMAT_NV61;  
}
