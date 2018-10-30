package com.ms.warehouse.manage.entity;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXMLUtils {
	 /**
     * 将Document对象转为Map（String→Document→Map）
     * @param Document
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, Object> Dom2Map(Document doc){  
        Map<String, Object> map = new HashMap<String, Object>();  
        if(doc == null)  
            return map;  
        Element root = doc.getRootElement();  
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {  
            Element e = (Element) iterator.next();  
            //System.out.println(e.getName());  
            List list = e.elements();  
            if(list.size() > 0){  
                map.put(e.getName(), Dom2Map(e));  
            }else  
                map.put(e.getName(), e.getText());  
        }  
        return map;  
    }

    /**
     * 将Element对象转为Map（String→Document→Element→Map）
     * @param Element
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map Dom2Map(Element e){  
        Map map = new HashMap();  
        List list = e.elements();  
        if(list.size() > 0){  
            for (int i = 0;i < list.size(); i++) {  
                Element iter = (Element) list.get(i);  
                List mapList = new ArrayList();  
                if(iter.elements().size() > 0){  
                    Map m = Dom2Map(iter);  
                    if(map.get(iter.getName()) != null){  
                        Object obj = map.get(iter.getName());  
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = new ArrayList();  
                            mapList.add(obj);  
                            mapList.add(m); 
                        }  
                        if(obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = (List) obj;  
                            mapList.add(m);
                        }  
                        map.put(iter.getName(), mapList); 
                    }else  
                        map.put(iter.getName(), m);  
                }  
                else{  
                    if(map.get(iter.getName()) != null){  
                        Object obj = map.get(iter.getName()); 
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = new ArrayList();  
                            mapList.add(obj);  
                            mapList.add(iter.getText());  
                        }  
                        if(obj.getClass().getName().equals("java.util.ArrayList")){  
                            mapList = (List) obj;  
                            mapList.add(iter.getText());  
                        }  
                        map.put(iter.getName(), mapList); 
                    }else  
                        map.put(iter.getName(), iter.getText());//公共map resultCode=0
                }  
            }  
        }else  
            map.put(e.getName(), e.getText());  
        return map;  
    }  

    public static void main(String[] args) {   
        String str1 = "<xml><return_code><![CDATA[FAIL]]></return_code>" +
                "       <return_msg><![CDATA[openid is invalid]]></return_msg>" +
                "       </xml>";
        SAXReader saxReader = new SAXReader();
        Document document;
        try {
            document = saxReader.read(new ByteArrayInputStream(str1.getBytes()));
            Map map = Dom2Map(document);
            System.out.println("map>>> " + map);
            /*
            {DB_ID=EUR, CHANNEL_ID=11, USERNAME=tom, PASSWORD=sss, POOL_ID=2}
            {BODY={BUSLIST=[{TRACE_ID=97D2C7D26224A2DAE9A1CB501E60F395, PHONE_NO=7107300212, LANG=zh_CN, TENANT_ID=EUR}, {TRACE_ID=444424A2DAE9A1CB501E60F395, PHONE_NO=2222300212, LANG=zh_CN, TENANT_ID=USA}]}, HEADER={CHANNEL_ID=11, USERNAME=tom, PASSWORD=sss, POOL_ID=2}}
            */
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
