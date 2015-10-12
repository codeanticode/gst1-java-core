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

import org.freedesktop.gstreamer.GError;
import org.freedesktop.gstreamer.gl.GLAPI;
import org.freedesktop.gstreamer.gl.GLContext;
import org.freedesktop.gstreamer.gl.GLDisplay;
import org.freedesktop.gstreamer.gl.GLDisplayType;

/**
 *
 * http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-bad-libs/html/GstGLDisplay.html
 */
public interface GstGLDisplayAPI extends com.sun.jna.Library {     
    GstGLDisplayAPI GSTGLDISPLAYAPI_API = GstNative.load(GstGLDisplayAPI.class);
     
    public static final String GST_GL_DISPLAY_TYPE_NONE_NAME = "gst.gl.GLDisplay.none";
    public static final String GST_GL_DISPLAY_TYPE_X11_NAME = "gst.gl.GLDisplay.x11";
    public static final String GST_GL_DISPLAY_TYPE_WAYLAND_NAME = "gst.gl.GLDisplay.wayland";
    public static final String GST_GL_DISPLAY_TYPE_COCOA_NAME = "gst.gl.GLDisplay.cocoa";    
    public static final String GST_GL_DISPLAY_TYPE_WIN32_NAME = "gst.gl.GLDisplay.win32";
    public static final String GST_GL_DISPLAY_TYPE_DISPMANX_NAME = "gst.gl.GLDisplay.dispmanx";
    public static final String GST_GL_DISPLAY_TYPE_EGL_NAME = "gst.gl.GLDisplay.egl";
    public static final String GST_GL_DISPLAY_TYPE_ANY_NAME = "gst.gl.GLDisplay.any";
    
    GLDisplay gst_gl_display_new();
    int gst_gl_display_get_handle(GLDisplay display);
    GLDisplayType gst_gl_display_get_handle_type(GLDisplay display);
    void gst_gl_display_filter_gl_api(GLDisplay display, GLAPI api);
    GLAPI gst_gl_display_get_gl_api(GLDisplay display);
    GLAPI gst_gl_display_get_gl_api_unlocked(GLDisplay display);
    void gst_context_set_gl_display(GstContext context, GLDisplay[] display);
    boolean gst_gl_display_create_context(GLDisplay display, GLContext other_context, GLContext[] p_context, GError[] error);
    GLContext gst_gl_display_get_gl_context_for_thread(GLDisplay display, GThread thread);
    boolean gst_gl_display_add_context(GLDisplay display, GLContext context);
}
