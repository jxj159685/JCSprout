package com.crossoverjie.design.pattern.decorate;

/**
 * 功能描述 进化的皮卡丘 装饰一下
 *
 * @Author ShareDream.J
 * @Date 2020/6/19 9:59
 * @CopyRight 杭州十二章纹文化传播有限公司 @2015-2022
 */
public class Pikaqiu extends Piqiu {
    int shiWanVT() {
        System.out.println("皮卡丘技能基础");
        return super.shiWanVT() * 10;
    }
}
