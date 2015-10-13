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

import com.sun.jna.Pointer;
import org.freedesktop.gstreamer.GError;
import org.freedesktop.gstreamer.gl.GLAPI;
import org.freedesktop.gstreamer.gl.GLContext;
import org.freedesktop.gstreamer.gl.GLDisplay;
import org.freedesktop.gstreamer.gl.GLPlatform;
import org.freedesktop.gstreamer.gl.GLWindow;
import org.freedesktop.gstreamer.lowlevel.annotations.CallerOwnsReturn;

/**
 *
 * http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-bad-libs/html/GstGLContext.html
 */
public interface GstGLContextAPI extends com.sun.jna.Library {
    GstGLContextAPI GSTGLCONTEXT_API = GstNative.load(GstGLContextAPI.class);

    public static final String GST_GL_CONTEXT_TYPE_CGL = "gst.gl.context.CGL";
    public static final String GST_GL_CONTEXT_TYPE_GLX = "gst.gl.context.GLX";
    public static final String GST_GL_CONTEXT_TYPE_EGL = "gst.gl.context.EGL";
    public static final String GST_GL_CONTEXT_TYPE_WGL = "gst.gl.context.WGL";
    public static final String GST_GL_CONTEXT_TYPE_EAGL = "gst.gl.context.EAGL";
        
    @CallerOwnsReturn GLContext gst_gl_context_new(GLDisplay display);
    @CallerOwnsReturn GLContext gst_gl_context_new_wrapped(GLDisplay display, int handle, GLPlatform contextType, GLAPI availableApis);
    boolean gst_gl_context_activate(GLContext context, boolean activate);
    GThread gst_gl_context_get_thread(GLContext context);
    @CallerOwnsReturn GLContext gst_gl_context_get_current();
    GLDisplay gst_gl_context_get_display(GLContext context);
    Pointer gst_gl_context_get_proc_address (GLContext context, String name);
    GLPlatform gst_gl_context_get_gl_platform(GLContext context);
    GLAPI gst_gl_context_get_gl_api(GLContext context);
    Pointer gst_gl_context_get_gl_context(GLContext context);
    boolean gst_gl_context_can_share(GLContext context, GLContext otherContext);

    boolean gst_gl_context_create(GLContext context, GLContext otherContext, GError[] error);
    void gst_gl_context_destroy(GLContext context);
    Pointer gst_gl_context_default_get_proc_address(GLAPI glApi, String name);
    
    boolean gst_gl_context_set_window(GLContext context, GLWindow window);
    GLWindow gst_gl_context_get_window(GLContext context);
    void gst_gl_context_get_gl_version(GLContext context, int[] maj, int[] min);
    boolean gst_gl_context_check_gl_version(GLContext context, GLAPI api, int maj, int min);
    boolean gst_gl_context_check_feature(GLContext context, String feature);

    int gst_gl_context_get_current_gl_context(GLPlatform platform);
    GLAPI gst_gl_context_get_current_gl_api(int[] major, int[] minor);
    boolean gst_gl_context_fill_info(GLContext context, GError[] error);
}
