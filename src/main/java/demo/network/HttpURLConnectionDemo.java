package demo.network;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class HttpURLConnectionDemo
{
    public static void main(String[] args)
            throws Exception
    {

        //发送 POST 请求
        String url = "http://ipapi.ipip.net/find_status";
        String data = "isBirdex=1&q=笨鸟";
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
//        headers.put("Cookie", "JSESSIONID=DACE9DCE56E284A2935019E50FB0B35B; rememberMe=ngo7OjXXDu/EEOifwvextvcW3WREXfQB7KlrOkw5biqEcR82IZV9R3MLEdASHGfB2J2JQi2i5vCm3L8NIZkIMGT4v12wYJhagbal5M8tVSHAGmuALSeMwyjW/A0rw5YOmMYcOwYDv3XAF4uyI7p3wqxKGRgj9QarSrJuG+zU9SCsWtaMGOymgQr+6Haa6WKPwl8zy9b+Gmpx+s63n1SWKY8XRWFuC3eKlaDUi/rcS2BW7PX7h9Moq7AcYVKhH3XS4fgfhi5BpLTjFXw6D+qCiFbZZoKcDCWxTewxG8o8XQ3Zv7ZHmbuZ9jSPkBXkboEt1YgdfzbOjIkrQ5/rQb2CTAYqdRPdXXO4XyB9PmtOH14d2eRKnzP5JvA8TqED9L9Sd8A6AxRcW1FFuvM6ji2OFJhpSX/v2XXYkoFt7/D1RgdPb2vGA+7HNCzMxqUWnNmoE02wS4csXMLZ6X0GpUdL/KDQEF7VSqquTT+vJfd9mnQKVQnlOK0gKxn70OeT1dhZskDHlE+C2/o47Omf3l95MA==");
//        headers.put("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Token", "cc87f3c77747bccbaaee35006da1ebb65e0bad57");
        String result = sendGet(url, data, headers);
        System.out.println("返回结果：" + result);

        //发送 POST 请求
//        String url = "http://ipapi.ipip.net/geo/status";
//        String data = "isBirdex=1&q=笨鸟";
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Accept", "*/*");
//        headers.put("Token", "cc87f3c77747bccbaaee35006da1ebb65e0bad57");
//        String result = sendPost(url, data, headers);
//        System.out.println("返回结果：" + result);

//        wxcreate("70abc"); // 400  200
//        wxget("7asdf0");  // 404   200

    }

    public static void wxget(String user) throws Exception
    {
        String url = "https://a1.easemob.com/0001234/gegejia/users/" + user;
        String token = getHuanXinToken();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + token);
//        System.out.println(headers);
        String result = sendGet(url,null, headers);

        System.out.println("result: " + result);

//        if (result == null || "".equals(result))
//            System.out.println("shi null");
//        else
//            System.out.println("not null");
////        System.out.println("result: " + result);
//        Map<String, Object> re = (Map<String, Object>)JSON.parse(result);
//        System.out.println(re);
//        System.out.println(re.get("count"));
    }

    public static void wxcreate(String user) throws Exception
    {
        String url = "https://a1.easemob.com/0001234/gegejia/users";
        String data = "{\"username\": \"" + user + "\",\"password\": \"" + strToMD5(user + "yangegegegeyan" + "huanxin") + "\"}";
//        System.out.println(data);
        String token = getHuanXinToken();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + token);
//        System.out.println(headers);
        String resultJSON = sendPost(url, data, headers);
        System.out.println("result: " + resultJSON);
        Map<String, Object> resultMap = (Map<String, Object>)JSON.parse(resultJSON);
        List<Object> entities = (List<Object>)resultMap.get("entities");
        System.out.println(entities);
    }


    public static String sendGet(String reqUrl, String data, Map<String, String> headers)
            throws IOException
    {
        StringBuffer buffer = null;
        InputStream in = null;
        String responseCode = null;
        try
        {
            buffer = new StringBuffer();
            if (null != data && !"".equals(data))
            {
                if (reqUrl.indexOf("?") > -1)
                {
                    reqUrl += data;
                }
                else
                {
                    reqUrl = reqUrl + "?" + data;
                }
            }
            URL url = new URL(reqUrl);
            // 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类的子类HttpURLConnection,故此处最好将其转化为HttpURLConnection类型的对象,
            // 以便用到HttpURLConnection更多的API.如下:
            HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();

            // 赋值请求头如 Content-Type、Cookie、User-Agent ...
            for (String key : headers.keySet())
            {
                httpUrlConnection.setRequestProperty(key, headers.get(key));
            }

            httpUrlConnection.setConnectTimeout(30000); // 设置连接主机超时（单位：毫秒）
            httpUrlConnection.setReadTimeout(30000); // 设置从主机读取数据超时（单位：毫秒）

            //connect()函数会根据HttpURLConnection对象的配置值生成http头部信息，因此在调用connect函数之前，就必须把所有的头部配置准备好
            //connect()函数，实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求
            httpUrlConnection.connect();

            // 调用HttpURLConnection连接对象的getInputStream()函数, 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。

            // getResponseCode 内部也会调用 getInputStream()
            responseCode = httpUrlConnection.getResponseCode() + "";
            System.out.println("httpUrlConnection.getResponseCode(): " + responseCode);
            in = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String str = null;
            while ((str = bufferedReader.readLine()) != null)
            {
                buffer.append(str);
            }
        }
        catch (IOException e)
        {
            System.out.println("发送 POST 请求出现异常！");
//            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(in != null)
                {
                    in.close();
                }
            }
            catch(IOException ex)
            {
//                ex.printStackTrace();
            }
        }

        return buffer.toString();
//        return responseCode;
    }

    /**
     *
     * @param reqUrl 请求地址
     * @param data 请求参数map
     * @param headers  请求头信息map
     * @return
     * @throws IOException
     */
    public static String sendPost(String reqUrl, String data, Map<String, String> headers)
            throws IOException
    {
        StringBuffer buffer = null;
        OutputStream out = null;
        InputStream in = null;
        String responseCode = null;
        try
        {
            buffer = new StringBuffer();
            URL url = new URL(reqUrl);
            // 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类的子类HttpURLConnection,故此处最好将其转化为HttpURLConnection类型的对象,
            // 以便用到HttpURLConnection更多的API.如下:
            HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();

            // 赋值请求头如 Content-Type、Cookie、User-Agent ...
            for (String key : headers.keySet())
            {
                httpUrlConnection.setRequestProperty(key, headers.get(key));
            }
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            httpUrlConnection.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpUrlConnection.setDoInput(true);
            // Post 请求不能使用缓存
            httpUrlConnection.setUseCaches(false);

            // 设定请求的方法为"POST"，默认是GET
            httpUrlConnection.setRequestMethod("POST");

            httpUrlConnection.setConnectTimeout(30000); // 设置连接主机超时（单位：毫秒）
            httpUrlConnection.setReadTimeout(30000); // 设置从主机读取数据超时（单位：毫秒）

            //connect()函数会根据HttpURLConnection对象的配置值生成http头部信息，因此在调用connect函数之前，就必须把所有的头部配置准备好
            //connect()函数，实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求
            httpUrlConnection.connect();

            //getOutputStream也会隐含的进行connect()
            out = httpUrlConnection.getOutputStream();
            out.write(data.getBytes()); //向对象输出流写出数据，这些数据将存到内存缓冲区中
            out.flush(); //刷新对象输出流，将任何字节都写入潜在的流中
            out.close();

            responseCode = httpUrlConnection.getResponseCode() + "";
            System.out.println("httpUrlConnection.getResponseCode(): " + responseCode);

            // 调用HttpURLConnection连接对象的getInputStream()函数, 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
            in = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里

            /**
             *  在http头后面紧跟着的是http请求的正文，正文的内容是通过outputStream流写入的，
             实际上outputStream不是一个网络流，充其量是个字符串流，往里面写入的东西不会立即发送到网络，
             而是存在于内存缓冲区中，待outputStream流关闭时，根据输入的内容生成http正文。
             至此，http请求的东西已经全部准备就绪。在getInputStream()函数调用的时候，就会把准备好的http请求
             正式发送到服务器了，然后返回一个输入流，用于读取服务器对于此次http请求的返回信息。由于http
             请求在getInputStream的时候已经发送出去了（包括http头和正文），因此在getInputStream()函数
             之后对connection对象进行设置（对http头的信息进行修改）或者写入outputStream（对正文进行修改）
             都是没有意义的了，执行这些操作会导致异常的发生
             */

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String str = null;
            while ((str = bufferedReader.readLine()) != null)
            {
                buffer.append(str);
            }
        }
        catch (IOException e)
        {
            System.out.println("发送 POST 请求出现异常！");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(out != null)
                {
                    out.close();
                }
                if(in != null)
                {
                    in.close();
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }

//        return buffer.toString();
        return responseCode;
    }

    /**
     * 把字符串转换成md5
     *
     * @param str
     * @return
     */
    public static String strToMD5(String str)
            throws UnsupportedEncodingException
    {

        try
        {
            byte[] input;
            input = str.getBytes("UTF-8");
            return bytesToHex(bytesToMD5(input));
        }
        catch (UnsupportedEncodingException e)
        {
            throw e;
        }
    }

    public static byte[] bytesToMD5(byte[] input)
    {
        // String md5str = null;
        byte[] buff = null;
        try
        {
            // 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算后获得字节数组
            buff = md.digest(input);
            // 把数组每一字节换成16进制连成md5字符串
            // md5str = bytesToHex(buff);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return buff;
    }

    /**
     * 把字节数组转成16进位制数
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes)
    {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 4; i < bytes.length - 4; i++)
        {
            digital = bytes[i];
            if (digital < 0)
            {
                digital += 256;
            }
            if (digital < 16)
            {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    public static String getHuanXinToken()
            throws IOException
    {
        Map<String, String> headers = new HashMap<>();
        String resultToken = sendPost1("https://a1.easemob.com/0001234/gegejia/token",
                "{\"grant_type\": \"client_credentials\",\"client_id\": \"YXA64y4aoLkGEeW9aQNG1iPfCw\",\"client_secret\": \"YXA618qMtxcxHWmTKJOa7dCu4S9mb04\"}", headers);
        Map<String, Object> result = (Map<String, Object>)JSON.parse(resultToken);
        String token = result.get("access_token") + "";
        return token;
    }

    public static String sendPost1(String reqUrl, String data, Map<String, String> headers)
            throws IOException
    {
        StringBuffer buffer = null;
        OutputStream out = null;
        InputStream in = null;
        String responseCode = null;
        try
        {
            buffer = new StringBuffer();
            URL url = new URL(reqUrl);
            // 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类的子类HttpURLConnection,故此处最好将其转化为HttpURLConnection类型的对象,
            // 以便用到HttpURLConnection更多的API.如下:
            HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();

            // 赋值请求头如 Content-Type、Cookie、User-Agent ...
            for (String key : headers.keySet())
            {
                httpUrlConnection.setRequestProperty(key, headers.get(key));
            }
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            httpUrlConnection.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpUrlConnection.setDoInput(true);
            // Post 请求不能使用缓存
            httpUrlConnection.setUseCaches(false);

            // 设定请求的方法为"POST"，默认是GET
            httpUrlConnection.setRequestMethod("POST");

            httpUrlConnection.setConnectTimeout(30000); // 设置连接主机超时（单位：毫秒）
            httpUrlConnection.setReadTimeout(30000); // 设置从主机读取数据超时（单位：毫秒）

            //connect()函数会根据HttpURLConnection对象的配置值生成http头部信息，因此在调用connect函数之前，就必须把所有的头部配置准备好
            //connect()函数，实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求
            httpUrlConnection.connect();

            //getOutputStream也会隐含的进行connect()
            out = httpUrlConnection.getOutputStream();
            out.write(data.getBytes()); //向对象输出流写出数据，这些数据将存到内存缓冲区中
            out.flush(); //刷新对象输出流，将任何字节都写入潜在的流中
            out.close();

            responseCode = httpUrlConnection.getResponseCode() + "";
            System.out.println("httpUrlConnection.getResponseCode(): " + responseCode);

            // 调用HttpURLConnection连接对象的getInputStream()函数, 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
            in = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里

            /**
             *  在http头后面紧跟着的是http请求的正文，正文的内容是通过outputStream流写入的，
             实际上outputStream不是一个网络流，充其量是个字符串流，往里面写入的东西不会立即发送到网络，
             而是存在于内存缓冲区中，待outputStream流关闭时，根据输入的内容生成http正文。
             至此，http请求的东西已经全部准备就绪。在getInputStream()函数调用的时候，就会把准备好的http请求
             正式发送到服务器了，然后返回一个输入流，用于读取服务器对于此次http请求的返回信息。由于http
             请求在getInputStream的时候已经发送出去了（包括http头和正文），因此在getInputStream()函数
             之后对connection对象进行设置（对http头的信息进行修改）或者写入outputStream（对正文进行修改）
             都是没有意义的了，执行这些操作会导致异常的发生
             */

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String str = null;
            while ((str = bufferedReader.readLine()) != null)
            {
                buffer.append(str);
            }
        }
        catch (IOException e)
        {
            System.out.println("发送 POST 请求出现异常！");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(out != null)
                {
                    out.close();
                }
                if(in != null)
                {
                    in.close();
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }

        return buffer.toString();
//        return responseCode;
    }
}