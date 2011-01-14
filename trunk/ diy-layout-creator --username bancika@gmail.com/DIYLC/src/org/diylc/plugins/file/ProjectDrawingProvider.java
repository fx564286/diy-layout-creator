package org.diylc.plugins.file;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.EnumSet;

import org.diylc.common.DrawOption;
import org.diylc.common.IPlugInPort;

import com.diyfever.gui.IDrawingProvider;

/**
 * {@link IDrawingProvider} implementation that uses {@link IPlugInPort} to draw
 * a project onto the canvas.
 * 
 * @author Branislav Stojkovic
 */
public class ProjectDrawingProvider implements IDrawingProvider {

	private IPlugInPort plugInPort;

	public ProjectDrawingProvider(IPlugInPort plugInPort) {
		super();
		this.plugInPort = plugInPort;
	}

	@Override
	public void draw(Graphics g) {
		plugInPort.draw((Graphics2D) g, EnumSet.of(DrawOption.ZOOM, DrawOption.ANTIALIASING), null);
	}

	@Override
	public Dimension getSize() {
		return plugInPort.getCanvasDimensions(true);
	}
}