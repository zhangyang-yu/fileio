

import java.io.*;


public class FileInPutStreamAndReader {
    /**
     * 流分类
     * 字节流    字符流    缓冲流    转换流
     * 输入流    输出流
     */
    public static void main(String[] args) {
//        String s = fileReader ();
//        File file = new File ("D://trs/cpec-api/log/info/api-info-1.log");
//        fileWriter(s,file);
       // fileOutputStream();
       // BufferedInOutputStream();
     //   BufferedReaderWrite();
        inputStreamReaderAndWrite();
    }

    /**
     * 文件字符输入流：把文件内容输入到内存中
     * 只能读取文本文件的内容
     */
     private static String   fileReader()  {
         File file = new File ("D://trs/cpec-api/log/info/api-info.log");
         FileReader fileReader = null;
        StringBuffer sb=new StringBuffer ();
         try {
             fileReader = new FileReader (file);
             char[] ch=new char[1024];
             int len=0;
             while ( (len=fileReader.read(ch)) !=-1)
             {
                 sb.append (ch,0,len);
             }
         } catch (Exception e) {
             e.printStackTrace ();
         }finally {
             if(fileReader!=null)
             {
                 try {
                     fileReader.close ();
                 } catch (IOException e) {
                     e.printStackTrace ();
                 }
             }
         }
        return sb.toString ();
     }

    /**
     * 文件字符输出流，把内存中的字符输入到文件中
     * @param content
     */
     private  static void fileWriter(String content,File file)
    {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter (file);
            fileWriter.write (content);
        } catch (IOException e) {
            e.printStackTrace ();
        }finally {
            if(fileWriter!=null)
            {
                try {
                    fileWriter.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }

        }
    }

    /**
     * 文件字节输入流 把文件中的内容以字节的形式输入到内存中
     * @return
     */
    private  static String fileInputStream()
    {
        File file = new File ("D://trs/cpec-api/log/info/api-info-1.log");
        FileInputStream fileInputStream = null;
        StringBuffer sb=new StringBuffer ();
        try {
            fileInputStream = new FileInputStream (file);
            byte[] ch=new byte[1024];
            int len =0;
             String str="";
            while ((len=fileInputStream.read (ch))!=-1)
            {
                for (int i = 0; i <len ; i++) {
                    str=new String (ch);
                    sb.append (str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }finally {
            if(fileInputStream!=null)
            {
                try {
                    fileInputStream.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
        return  sb.toString ();
    }

    /**
     * 字符文件输出流 把内存中的数据输入到文件中
     */
    private  static void  fileOutputStream()
    {
        File file = new File ("C://Users/zhangyang/Desktop/001.mp4");
        File file1 = new File ("C://Users/zhangyang/Desktop/002.mp4");
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (file);
            fileOutputStream = new FileOutputStream (file1);
            byte[] ch=new byte[1024];
            int len=0;
            while ((len=fileInputStream.read (ch))!=-1)
            {
                fileOutputStream.write (ch);
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }if(fileOutputStream!=null)
            {
                try {
                    fileOutputStream.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    /**
     * 字节输入输出缓冲流  提高文件的转换效率
     */
    private  static  void  BufferedInOutputStream()
    {
        File file = new File ("C://Users/zhangyang/Desktop/001.mp4");
        File fileCp = new File ("C://Users/zhangyang/Desktop/002.mp4");
        FileInputStream fileInputStream= null;
        FileOutputStream fileOutputStream=null;
        BufferedInputStream bufferedInputStream =null;
        BufferedOutputStream bufferedOutputStream=null;
        long start = System.currentTimeMillis ();
        try {
            fileInputStream = new FileInputStream (file);
            fileOutputStream = new FileOutputStream (fileCp);
            bufferedInputStream = new BufferedInputStream (fileInputStream);
            bufferedOutputStream = new BufferedOutputStream (fileOutputStream);
            byte[] b=new byte[1024];
            int len=0;
            while ((len=bufferedInputStream.read (b))!=-1)
            {
                bufferedOutputStream.write (b);
            }
            bufferedOutputStream.flush ();
        } catch (Exception e) {
            e.printStackTrace ();
        }finally {
            if(bufferedInputStream!=null)
            {
                try {
                    bufferedInputStream.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }if(bufferedOutputStream!=null)
            {
                try {
                    bufferedOutputStream.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
        long end = System.currentTimeMillis ();
        long l = end - start;
        System.out.println ("使用时间:"+l);

    }

    /**
     * 字符输入输出缓冲流
     */
    private  static  void  BufferedReaderWrite()
    {
        File file = new File ("D://trs/cpec-api/log/info/api-info.log");
        File fileCp = new File ("D://trs/cpec-api/log/info/api-info-2.log");
        FileReader fileReader = null;
        FileWriter fileWriter=null;
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        long start = System.currentTimeMillis ();

        try {
            fileReader = new FileReader (file);
            fileWriter = new FileWriter (fileCp);
            bufferedReader=new BufferedReader (fileReader);
            bufferedWriter = new BufferedWriter (fileWriter);
            char[] ch=new char[1024];
            int len=0;
            while ((len=bufferedReader.read (ch))!=-1)
            {
                bufferedWriter.write (ch);
            }
            bufferedWriter.flush ();
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            if(bufferedReader!=null)
            {
                try {
                    bufferedReader.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }if(bufferedWriter!=null)
            {
                try {
                    bufferedWriter.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
        long end=System.currentTimeMillis ();
        long l = end - start;
        System.out.println ("需要时间: "+l);
    }

    /**
     * 字节字符转换流
     */
    private  static  void inputStreamReaderAndWrite()
    {
        File file = new File ("D://trs/cpec-api/log/info/api-info.log");
        File fileCp = new File ("D://trs/cpec-api/log/info/api-info-4.log");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            fileInputStream = new FileInputStream (file);
            fileOutputStream = new FileOutputStream (fileCp);
            inputStreamReader = new InputStreamReader (fileInputStream);
            outputStreamWriter = new OutputStreamWriter (fileOutputStream);
            char[] ch=new char[1024];
            int len=0;
            while ((len=inputStreamReader.read (ch))!=-1)
            {
                outputStreamWriter.write (ch,0,len);
            }
            outputStreamWriter.flush ();
        } catch (Exception e) {
            e.printStackTrace ();
        }finally {
            if(inputStreamReader!=null){
                try {
                    inputStreamReader.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }if(outputStreamWriter!=null)
            {
                try {
                    outputStreamWriter.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }if(fileInputStream!=null)
            {
                try {
                    fileInputStream.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }if(fileOutputStream!=null)
            {
                try {
                    fileOutputStream.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }
}
