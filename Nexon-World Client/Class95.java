/* Class95 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.io.IOException;

final class Class95
{
    static boolean aBoolean798 = false;
    static int anInt799;
    static int[] anIntArray800 = new int[13];
    
    static final void method920(byte i) throws IOException {
	do {
	    try {
		if (i < 77)
		    method921(true);
		if (aa_Sub1.aClass123_3561 == null
		    || (Class62.anInt490 ^ 0xffffffff) >= -1)
		    break;
		((Class98_Sub22) Class160.aClass98_Sub22_1257).anInt3991 = 0;
		for (;;) {
		    Class98_Sub11 class98_sub11
			= ((Class98_Sub11)
			   Class336.aClass148_2827.method2418(32));
		    if (class98_sub11 == null
			|| (((((Class98_Sub22) Class160.aClass98_Sub22_1257)
			      .aByteArray3992).length
			     + -(((Class98_Sub22) Class160.aClass98_Sub22_1257)
				 .anInt3991))
			    < ((Class98_Sub11) class98_sub11).anInt3869))
			break;
		    Class160.aClass98_Sub22_1257.method1217
			((((Class98_Sub22) (((Class98_Sub11) class98_sub11)
					    .aClass98_Sub22_Sub1_3865))
			  .aByteArray3992),
			 ((Class98_Sub11) class98_sub11).anInt3869, -1, 0);
		    Class62.anInt490
			-= ((Class98_Sub11) class98_sub11).anInt3869;
		    class98_sub11.method942(90);
		    ((Class98_Sub11) class98_sub11)
			.aClass98_Sub22_Sub1_3865.method1201(0);
		    class98_sub11.method1125((byte) 6);
		}
		aa_Sub1.aClass123_3561.method2202
		    (-24305,
		     ((Class98_Sub22) Class160.aClass98_Sub22_1257).anInt3991,
		     (((Class98_Sub22) Class160.aClass98_Sub22_1257)
		      .aByteArray3992),
		     0);
		Class98_Sub50.anInt4289
		    += (((Class98_Sub22) Class160.aClass98_Sub22_1257)
			.anInt3991);
		Class196.anInt1511 = 0;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "ft.B(" + i + ')');
	    }
	    break;
	} while (false);
    }
    
    public static void method921(boolean bool) {
	try {
	    if (bool != false)
		anInt799 = 59;
	    anIntArray800 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "ft.A(" + bool + ')');
	}
    }
}
