package demo.xss;

//import com.google.common.base.Throwables;
import org.owasp.html.*;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;

/**
 * 防xss攻击
 *
 * @author xiongl
 * @create 2016-08-21 15:22
 */
public class SanitizerDemo
{
    
    private static final PolicyFactory POLICY_HTML_TAG_DEFINITION = new HtmlPolicyBuilder().disallowElements("DOCTYPE")
        .disallowElements("a", "abbr", "acronym", "address", "applet", "area", "article", "aside", "audio")
        .disallowElements("b", "base", "basefont", "bdi", "bdo", "big", "blockquote", "body", "br", "button")
        .disallowElements("canvas", "caption", "center", "cite", "code", "col", "colgroup", "command")
        .disallowElements("datalist", "dd", "del", "details", "dfn", "dialog", "dir", "div", "dl", "dt")
        .disallowElements("em", "embed")
        .disallowElements("fieldset", "figcaption", "figure", "font", "footer", "form", "frame", "frameset")
        .disallowElements("h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hr", "html")
        .disallowElements("i", "iframe", "img", "input", "ins")
        .disallowElements("kbd", "keygen")
        .disallowElements("label", "legend", "li", "link")
        .disallowElements("main", "map", "mark", "menu", "menuitem", "meta", "meta")
        .disallowElements("nav", "noframes", "noscript")
        .disallowElements("object", "ol", "optgroup", "option", "output")
        .disallowElements("p", "param", "pre", "progress")
        .disallowElements("q")
        .disallowElements("rp", "rt", "ruby")
        .disallowElements("s", "samp", "script", "section", "select", "small", "source", "span", "strike", "strong", "style", "sub", "summary", "sup")
        .disallowElements("table", "tbody", "td", "textarea", "tfoot", "th", "thead", "time", "title", "tr", "track", "tt")
        .disallowElements("u", "ul")
        .disallowElements("var", "video")
        .disallowElements("wbr")
        .toFactory();
        
    public static void main(String[] args)
    {
        String drityInput = "<script>alert(1)321</script>" + "&lt;script&gt;xxx&lt;/script&gt;，毛泽东</a>"
            + "<p align='center' style='z-index:999; width:100%; align:left;display:block;overflow:hidden;color:red;'>&lt;&lt;&lt;&lt;1111 &nbsp; </p>"
            + "<iframe src='javascript:xxx'></iframe>" + "<xxx>xxx</xxx>fasfas4124";
        // String str = "<script>alert(1)321</script>";
        // System.out.println(StringEscapeUtils.escapeHtml(str));
        System.out.println(filterHtmlTags(drityInput));
        System.out.println(HtmlUtils.htmlUnescape("&lt;script&gt;xxx&lt;/script&gt;"));
    }
    
    /**
     * 过滤html标签
     *
     * @param drityStr
     * @return
     */
    public static String filterHtmlTags(String drityStr)
    {
//        if (StringUtils.isEmpty(drityStr))
//        {
//            return "";
//        }
//        StringBuffer out = new StringBuffer();
//        try
//        {
//            HtmlStreamRenderer renderer = HtmlStreamRenderer.create(out, new Handler<IOException>()
//            {
//                public void handle(IOException ex)
//                {
//                    Throwables.propagate(ex);
//                }
//            }, new Handler<String>()
//            {
//                public void handle(String x)
//                {
//                    throw new AssertionError(x);
//                }
//            });
//            HtmlSanitizer.sanitize(HtmlUtils.htmlUnescape(drityStr), POLICY_HTML_TAG_DEFINITION.apply(renderer));
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return HtmlUtils.htmlUnescape(out.toString());
        return null;
    }
    
}
