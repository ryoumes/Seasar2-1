package org.mule.extras.seasar2.examples.helloworld.file;

import org.mule.extras.seasar2.sender.S2MuleSender;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;
import org.seasar.framework.exception.ResourceNotFoundRuntimeException;

public class HelloWorldFile {
    
    // dicon ファイル
    private static final String CONFIGURE_PATH = "helloworld-send-file.dicon";
    
    private static S2Container container;
    
    public static void main(String[] args)
    {
    	
        try
        {
            // dicon ファイルを指定して S2 コンテナを生成する
            container = S2ContainerFactory.create(CONFIGURE_PATH);
            
            //コンテナの初期化
            container.init();
            
            // S2MuleSender のインスタンスを取得する
            S2MuleSender sender = (S2MuleSender) container.getComponent(S2MuleSender.class);
            
            // メッセージを送信する
            sender.dispatch("Hello World!");
            
            // 成功
            System.out.println("The message is sent successfully.");
                        
        }
        catch (ResourceNotFoundRuntimeException e)
        {
            System.out.println("dicon ファイルが見つかりません： " + CONFIGURE_PATH);
        }
        finally
        {
        	//コンテナの破棄
            container.destroy();
        }
    }
    
}