package org.freedesktop.gstreamer.gl;

import org.freedesktop.gstreamer.lowlevel.IntegerEnum;

public class GLMemory {
  final public static int GST_MINI_OBJECT_FLAG_LAST  = 16;
  final public static int GST_MEMORY_FLAG_LAST = (GST_MINI_OBJECT_FLAG_LAST << 16);
      
  final public static int GST_GL_MEMORY_FLAG_DOWNLOAD_INITTED = GST_MEMORY_FLAG_LAST << 0;
  final public static int GST_GL_MEMORY_FLAG_UPLOAD_INITTED = GST_MEMORY_FLAG_LAST << 1;
  final public static int GST_GL_MEMORY_FLAG_NEED_DOWNLOAD = GST_MEMORY_FLAG_LAST << 2;
  final public static int GST_GL_MEMORY_FLAG_NEED_UPLOAD = GST_MEMORY_FLAG_LAST << 3;


  final public static int GST_MAP_READ      = (1 << 0);
  final public static int GST_MAP_WRITE     = (1 << 1);
  final public static int GST_MAP_FLAG_LAST = (1 << 16);
//  final public static int GST_MAP_FLAG_LAST = 65536;
//

  final public static int GST_MAP_GL = GST_MAP_FLAG_LAST << 1;
}
