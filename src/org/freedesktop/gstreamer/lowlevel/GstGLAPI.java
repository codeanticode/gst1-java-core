/*
 * GStreamer
 * Copyright (C) 2012 Matthew Waters <ystreet00@gmail.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA 02110-1301, USA.
 */
package org.freedesktop.gstreamer.lowlevel;

import org.freedesktop.gstreamer.gl.GLAPI;
import org.freedesktop.gstreamer.gl.GLPlatform;

/**
 *
 * http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-bad-libs/html/gst-plugins-bad-libs-GstGLAPI.html
 */
public interface GstGLAPI extends com.sun.jna.Library { 
    GstGLAPI GSTGLAPI_API = GstNative.load(GstGLAPI.class);
    
    public static final String GST_GL_API_OPENGL_NAME = "opengl";
    public static final String GST_GL_API_OPENGL3_NAME = "opengl3";
    public static final String GST_GL_API_GLES1_NAME = "gles1";
    public static final String GST_GL_API_GLES2_NAME = "gles2";

    String gst_gl_api_to_string(GLAPI api);
    GLAPI gst_gl_api_from_string(String apiStr);

    String gst_gl_platform_to_string(GLPlatform api);
    GLPlatform gst_gl_platform_from_string(String platformStr);
}
