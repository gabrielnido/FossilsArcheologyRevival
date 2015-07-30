package com.github.revival.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelVelociraptor extends ModelBase {
    public ModelRenderer lowerBody;
    public ModelRenderer leftThigh;
    public ModelRenderer rightThigh;
    public ModelRenderer upperBody;
    public ModelRenderer tail1;
    public ModelRenderer neck;
    public ModelRenderer leftUpperArm;
    public ModelRenderer rightUpperArm;
    public ModelRenderer head;
    public ModelRenderer upperJaw;
    public ModelRenderer lowerJaw;
    public ModelRenderer upperCrest;
    public ModelRenderer lowerCrest;
    public ModelRenderer leftUpperArmFeather;
    public ModelRenderer leftLowerArm;
    public ModelRenderer leftLowerArmFeather;
    public ModelRenderer rightUpperArmFeather;
    public ModelRenderer rightLowerArm;
    public ModelRenderer rightLowerArmFeather;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer tailFeather2;
    public ModelRenderer leftLeg;
    public ModelRenderer leftFoot;
    public ModelRenderer leftToeClaw1;
    public ModelRenderer leftToeClaw2;
    public ModelRenderer rightLeg;
    public ModelRenderer rightFoot;
    public ModelRenderer rightToeClaw1;
    public ModelRenderer rightToeClaw2;

    public ModelVelociraptor() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rightLowerArm = new ModelRenderer(this, 20, 21);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(-1.01F, 1.2F, 0.5F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, -6.2F, 2, 2, 5, 0.0F);
        this.setRotateAngle(rightLowerArm, 0.8726646259971648F, 0.0F, 0.0F);
        this.rightThigh = new ModelRenderer(this, 14, 35);
        this.rightThigh.setRotationPoint(-3.0F, 14.0F, 3.0F);
        this.rightThigh.addBox(-3.0F, -2.5F, -2.0F, 3, 7, 5, 0.0F);
        this.rightToeClaw2 = new ModelRenderer(this, 0, 40);
        this.rightToeClaw2.setRotationPoint(0.0F, 0.2F, -2.5F);
        this.rightToeClaw2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rightToeClaw2, -1.7627825445142729F, -0.0F, 0.0F);
        this.lowerJaw = new ModelRenderer(this, 49, 0);
        this.lowerJaw.setRotationPoint(0.0F, 0.0F, -4.53F);
        this.lowerJaw.addBox(-2.0F, -0.5F, -6.9F, 3, 1, 7, 0.0F);
        this.setRotateAngle(lowerJaw, -0.06924167156799095F, 0.0F, 0.0F);
        this.leftUpperArm = new ModelRenderer(this, 20, 13);
        this.leftUpperArm.mirror = true;
        this.leftUpperArm.setRotationPoint(3.0F, 1.9F, -4.0F);
        this.leftUpperArm.addBox(0.0F, -1.0F, -1.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(leftUpperArm, -0.06981317007977318F, 0.0F, 0.0F);
        this.upperJaw = new ModelRenderer(this, 28, 0);
        this.upperJaw.setRotationPoint(0.0F, -1.0F, -4.93F);
        this.upperJaw.addBox(-2.0F, -2.4F, -6.7F, 3, 3, 7, 0.0F);
        this.setRotateAngle(upperJaw, -0.0017453292519943296F, -0.0F, 0.0F);
        this.lowerCrest = new ModelRenderer(this, 38, 15);
        this.lowerCrest.setRotationPoint(-0.5F, -0.7F, -1.03F);
        this.lowerCrest.addBox(-0.5F, -1.5F, 0.6F, 1, 4, 5, 0.0F);
        this.setRotateAngle(lowerCrest, 0.13578661580515886F, 0.0F, 0.0F);
        this.rightLowerArmFeather = new ModelRenderer(this, 34, 34);
        this.rightLowerArmFeather.setRotationPoint(0.0F, -0.2F, 1.6F);
        this.rightLowerArmFeather.addBox(-0.5F, 1.7F, -8.1F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F);
        this.tailFeather2 = new ModelRenderer(this, 40, 35);
        this.tailFeather2.setRotationPoint(0.0F, -0.2F, -2.5F);
        this.tailFeather2.addBox(-3.5F, 0.5F, 10.1F, 7, 1, 12, 0.0F);
        this.setRotateAngle(tailFeather2, -0.004886921905584123F, -0.0F, 0.0F);
        this.rightUpperArmFeather = new ModelRenderer(this, 34, 34);
        this.rightUpperArmFeather.setRotationPoint(-1.0F, 0.1F, 0.9F);
        this.rightUpperArmFeather.addBox(-0.6F, -0.1F, -4.7F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F);
        this.leftToeClaw2 = new ModelRenderer(this, 0, 40);
        this.leftToeClaw2.setRotationPoint(0.0F, 0.2F, -2.5F);
        this.leftToeClaw2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(leftToeClaw2, -1.7627825445142729F, -0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 13);
        this.neck.setRotationPoint(0.0F, 0.8F, -3.5F);
        this.neck.addBox(-2.0F, -2.0F, -8.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(neck, -0.84334309456366F, 0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 49, 16);
        this.tail3.setRotationPoint(0.0F, 0.6F, 4.3F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
        this.setRotateAngle(tail3, -0.05253441048502932F, -0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.5F, 0.8F, -6.03F);
        this.head.addBox(-3.0F, -4.0F, -5.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(head, 0.9955358053375654F, 0.0F, 0.0F);
        this.leftUpperArmFeather = new ModelRenderer(this, 34, 34);
        this.leftUpperArmFeather.mirror = true;
        this.leftUpperArmFeather.setRotationPoint(1.0F, 0.1F, 0.9F);
        this.leftUpperArmFeather.addBox(-0.4F, -0.1F, -4.7F, 1, 4, 6, 0.0F);
        this.setRotateAngle(leftUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F);
        this.lowerBody = new ModelRenderer(this, 65, 12);
        this.lowerBody.setRotationPoint(0.0F, 9.9F, -2.5F);
        this.lowerBody.addBox(-4.0F, -1.0F, 0.0F, 8, 7, 9, 0.0F);
        this.setRotateAngle(lowerBody, -0.15554018104602801F, 0.0F, 0.0F);
        this.upperCrest = new ModelRenderer(this, 38, 15);
        this.upperCrest.mirror = true;
        this.upperCrest.setRotationPoint(-0.51F, -2.5F, -2.03F);
        this.upperCrest.addBox(-0.5F, -1.5F, 0.6F, 1, 4, 5, 0.0F);
        this.setRotateAngle(upperCrest, 0.4961971063419879F, -0.0F, 0.0F);
        this.leftToeClaw1 = new ModelRenderer(this, 0, 40);
        this.leftToeClaw1.setRotationPoint(-0.9F, 0.2F, -1.2F);
        this.leftToeClaw1.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftToeClaw1, -0.8726646259971648F, -0.0F, 0.0F);
        this.leftLeg = new ModelRenderer(this, 2, 25);
        this.leftLeg.mirror = true;
        this.leftLeg.setRotationPoint(1.2F, 2.2F, 2.2F);
        this.leftLeg.addBox(-1.0F, 0.4F, -6.7F, 2, 2, 7, 0.0F);
        this.setRotateAngle(leftLeg, 0.994837673636769F, 0.0F, 0.0F);
        this.leftLowerArmFeather = new ModelRenderer(this, 34, 34);
        this.leftLowerArmFeather.mirror = true;
        this.leftLowerArmFeather.setRotationPoint(0.0F, -0.2F, 1.6F);
        this.leftLowerArmFeather.addBox(-0.5F, 1.7F, -8.1F, 1, 4, 6, 0.0F);
        this.setRotateAngle(leftLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F);
        this.upperBody = new ModelRenderer(this, 67, 0);
        this.upperBody.setRotationPoint(0.0F, 1.1F, -0.5F);
        this.upperBody.addBox(-3.0F, -2.0F, -5.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(upperBody, 0.19338248112097173F, -0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 91, 0);
        this.tail1.setRotationPoint(0.0F, -1.0F, 8.5F);
        this.tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 7, 0.0F);
        this.setRotateAngle(tail1, 0.11903145498601327F, -0.0F, 0.0F);
        this.rightLeg = new ModelRenderer(this, 2, 25);
        this.rightLeg.setRotationPoint(-1.2F, 2.2F, 2.2F);
        this.rightLeg.addBox(-1.0F, 0.4F, -6.7F, 2, 2, 7, 0.0F);
        this.setRotateAngle(rightLeg, 0.9948376736367678F, -0.0F, 0.0F);
        this.rightUpperArm = new ModelRenderer(this, 20, 13);
        this.rightUpperArm.setRotationPoint(-3.0F, 1.9F, -4.0F);
        this.rightUpperArm.addBox(-2.0F, -1.0F, -1.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(rightUpperArm, -0.06981317007977318F, 0.0F, 0.0F);
        this.rightFoot = new ModelRenderer(this, 0, 34);
        this.rightFoot.setRotationPoint(-0.2F, 0.9F, -6.3F);
        this.rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(rightFoot, -0.9948376736367678F, -0.0F, 0.0F);
        this.leftThigh = new ModelRenderer(this, 14, 35);
        this.leftThigh.mirror = true;
        this.leftThigh.setRotationPoint(3.0F, 14.1F, 3.0F);
        this.leftThigh.addBox(0.0F, -2.5F, -2.0F, 3, 7, 5, 0.0F);
        this.tail2 = new ModelRenderer(this, 90, 13);
        this.tail2.setRotationPoint(0.0F, 0.2F, 6.7F);
        this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.leftLowerArm = new ModelRenderer(this, 20, 21);
        this.leftLowerArm.setRotationPoint(1.01F, 1.2F, 0.5F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, -6.2F, 2, 2, 5, 0.0F);
        this.setRotateAngle(leftLowerArm, 0.8726646259971648F, -0.0F, 0.0F);
        this.leftFoot = new ModelRenderer(this, 0, 34);
        this.leftFoot.setRotationPoint(0.2F, 0.7999999999999996F, -6.3F);
        this.leftFoot.addBox(-1.5F, 0.0F, -3.1F, 3, 2, 4, 0.0F);
        this.setRotateAngle(leftFoot, -0.9948376736367697F, 0.0F, 0.0F);
        this.rightToeClaw1 = new ModelRenderer(this, 0, 40);
        this.rightToeClaw1.setRotationPoint(0.9F, 0.2F, -1.2F);
        this.rightToeClaw1.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightToeClaw1, -0.8726646259971648F, -0.0F, 0.0F);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.rightToeClaw1.addChild(this.rightToeClaw2);
        this.head.addChild(this.lowerJaw);
        this.upperBody.addChild(this.leftUpperArm);
        this.head.addChild(this.upperJaw);
        this.head.addChild(this.lowerCrest);
        this.rightLowerArm.addChild(this.rightLowerArmFeather);
        this.tail3.addChild(this.tailFeather2);
        this.rightUpperArm.addChild(this.rightUpperArmFeather);
        this.leftToeClaw1.addChild(this.leftToeClaw2);
        this.upperBody.addChild(this.neck);
        this.tail2.addChild(this.tail3);
        this.neck.addChild(this.head);
        this.leftUpperArm.addChild(this.leftUpperArmFeather);
        this.head.addChild(this.upperCrest);
        this.leftFoot.addChild(this.leftToeClaw1);
        this.leftThigh.addChild(this.leftLeg);
        this.leftLowerArm.addChild(this.leftLowerArmFeather);
        this.lowerBody.addChild(this.upperBody);
        this.lowerBody.addChild(this.tail1);
        this.rightThigh.addChild(this.rightLeg);
        this.upperBody.addChild(this.rightUpperArm);
        this.rightLeg.addChild(this.rightFoot);
        this.tail1.addChild(this.tail2);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.leftLeg.addChild(this.leftFoot);
        this.rightFoot.addChild(this.rightToeClaw1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.rightThigh.render(f5);
        this.lowerBody.render(f5);
        this.leftThigh.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
