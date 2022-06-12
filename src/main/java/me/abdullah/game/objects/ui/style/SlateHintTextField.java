package me.abdullah.game.objects.ui.style;

import me.abdullah.game.objects.ui.HintTextField;

import javax.print.attribute.Attribute;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class SlateHintTextField extends HintTextField {

    public SlateHintTextField(String hint, int col) {
        super(hint, col);
        setBorder(new BorderUIResource.MatteBorderUIResource(0, 0, 1, 0, Color.black));

        Map<TextAttribute, Object> attr = new HashMap<>();
        attr.put(TextAttribute.FAMILY, "Montserrat");
        attr.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_LIGHT);
        setFont(new Font(attr));
    }
}
