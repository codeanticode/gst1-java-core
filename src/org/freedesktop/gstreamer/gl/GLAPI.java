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
package org.freedesktop.gstreamer.gl;

import java.util.HashMap;
import java.util.Map;
import org.freedesktop.gstreamer.lowlevel.EnumMapper;
import org.freedesktop.gstreamer.lowlevel.GstGLAPI;
import org.freedesktop.gstreamer.lowlevel.GstNative;
import org.freedesktop.gstreamer.lowlevel.IntegerEnum;

/**
 *
 * @author andres
 */
public enum GLAPI implements IntegerEnum {    
    GST_GL_API_NONE(0),
          
    GST_GL_API_OPENGL(1 << 0),
          
    GST_GL_API_OPENGL3(1 << 1),
          
    GST_GL_API_GLES1(1 << 15),
          
    GST_GL_API_GLES2(1 << 16),

    GST_GL_API_ANY(0xffffffff); 
    
    GLAPI(int type) {
        this.type = type;
        GstGLAPI glAPI = GstNative.load(GstGLAPI.class);
        this.name = glAPI.gst_gl_api_to_string(this);
    }     
  
    /**
     * Gets the native integer value for this type.
     * 
     * @return the native gstreamer value.
     */
    public int intValue() {
        return type;
    }
    
    /**
     * Gets the name of this message type.
     * 
     * @return the name of the message type.
     */
    public String getName() {
        return name;
    }
    
       /**
     * Gets a GLAPI that corresponds to the native integer value.
     * 
     * @param type the native value of the type.
     * @return a GLAPI.
     */
    public static final GLAPI valueOf(int type) {
        return EnumMapper.getInstance().valueOf(type, GLAPI.class);
    } 
    
    /**
     * Gets a GLAPI that corresponds to the name
     * 
     * @param name the gstreamer name of the type.
     * @return a GLAPI.
     */
    public static final GLAPI forName(String name) {
        GLAPI type = MapHolder.typeMap.get(name);
        return type != null ? type : GST_GL_API_NONE;
    }
    private final int type;
    private final String name;
    private static final class MapHolder {
        private static final Map<String, GLAPI> typeMap = new HashMap<String, GLAPI>();
        static {
            for (GLAPI t : GLAPI.values()) {
                typeMap.put(t.getName(), t);
            }
        }
    } 
}
    