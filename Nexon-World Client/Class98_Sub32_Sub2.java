/* Class98_Sub32_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

final class Class98_Sub32_Sub2 extends Class98_Sub32
{
    private Shape aShape5891;
    private Canvas aCanvas5892;
    private Rectangle aRectangle5893;
    private Image anImage5894;
    
    final void method1441(int i, int i_0_, int i_1_, Canvas canvas) {
	try {
	    aCanvas5892 = canvas;
	    aRectangle5893 = new Rectangle();
	    ((Class98_Sub32_Sub2) this).anInt4110 = i;
	    ((Class98_Sub32_Sub2) this).anInt4105 = i_0_;
	    ((Class98_Sub32_Sub2) this).anIntArray4108
		= new int[(((Class98_Sub32_Sub2) this).anInt4110
			   * ((Class98_Sub32_Sub2) this).anInt4105)];
	    if (i_1_ != 4095)
		method1441(-47, -17, -7, null);
	    DataBufferInt databufferint
		= new DataBufferInt(((Class98_Sub32_Sub2) this).anIntArray4108,
				    (((Class98_Sub32_Sub2) this)
				     .anIntArray4108).length);
	    DirectColorModel directcolormodel
		= new DirectColorModel(32, 16711680, 65280, 255);
	    WritableRaster writableraster
		= Raster.createWritableRaster((directcolormodel
						   .createCompatibleSampleModel
					       ((((Class98_Sub32_Sub2) this)
						 .anInt4105),
						(((Class98_Sub32_Sub2) this)
						 .anInt4110))),
					      databufferint, null);
	    anImage5894 = new BufferedImage(directcolormodel, writableraster,
					    false, new Hashtable());
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    final void method1434(Graphics graphics, int i, byte i_2_, int i_3_,
			  int i_4_, int i_5_, int i_6_, int i_7_) {
	try {
	    if (i_2_ == -125) {
		aShape5891 = graphics.getClip();
		aRectangle5893.width = i_4_;
		aRectangle5893.x = i;
		aRectangle5893.y = i_7_;
		aRectangle5893.height = i_6_;
		graphics.setClip(aRectangle5893);
		graphics.drawImage(anImage5894, i + -i_3_, -i_5_ + i_7_,
				   aCanvas5892);
		graphics.setClip(aShape5891);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
