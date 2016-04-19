package net.nightwhistler.htmlspanner.handlers;

import android.text.SpannableStringBuilder;

import net.nightwhistler.htmlspanner.SpanStack;
import net.nightwhistler.htmlspanner.css.CSSCompiler;
import net.nightwhistler.htmlspanner.style.Style;

import org.htmlcleaner.TagNode;

import java.util.Map;

/**
 * Created by ohmer on 4/19/16.
 * handle for Inline Styles
 */
public class CSSStyledTextHandler extends StyledTextHandler {

    public CSSStyledTextHandler() {
        super(new Style());
    }

    @Override
    public void handleTagNode(TagNode node, SpannableStringBuilder builder, int start, int end, Style useStyle, SpanStack stack) {
        if (getSpanner().isAllowStyling()) {
            String cssStyle = node.getAttributeByName("style");
            if (cssStyle != null) {
                Map<String, String> inlineStyles = CSSCompiler.parseInlineCSS(cssStyle);
                for (Map.Entry<String, String> entry : inlineStyles.entrySet()) {
                    CSSCompiler.StyleUpdater updater = CSSCompiler.getStyleUpdater(entry.getKey(), entry.getValue());
                    if ( updater != null ) {
                        useStyle = updater.updateStyle(useStyle, getSpanner() );
                    }
                }
            }
        }
        super.handleTagNode(node, builder, start, end, useStyle, stack);
    }
}
