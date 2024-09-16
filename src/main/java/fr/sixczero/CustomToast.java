package fr.sixczero;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.text.Text;
// Future "EasyLib" to-do Custom Toast
public class CustomToast implements Toast {

    private final Text title;
    private final Text message;
    private final long duration;
    private final ItemStack itemStack;
    private final int progressColor;
    private long startTime;
    private boolean hasStarted;
    private Identifier iconTexture;
    private int width;

    public CustomToast(Text title, Text message, Identifier iconTexture, long duration, int color) {
        this.title = title;
        this.message = message;
        this.itemStack = null;
        this.iconTexture = iconTexture;
        this.duration = duration;
        this.progressColor = color;
    }

    public CustomToast(Text title, Text message, ItemStack itemStack, long duration, int color) {
        this.title = title;
        this.message = message;
        this.itemStack = itemStack;
        this.duration = duration;
        this.progressColor = color;
    }

    @Override
    public Visibility draw(DrawContext context, ToastManager manager, long delta) {
        if (!hasStarted) {
            startTime = delta;
            hasStarted = true;
        }

        MinecraftClient client = MinecraftClient.getInstance();
        TextRenderer textRenderer = client.textRenderer;

        this.width = Math.max(textRenderer.getWidth(this.title), textRenderer.getWidth(this.message)) + 40;

        context.fill(160 - this.width, 0, 160, this.getHeight(), 0x80000000); // Black background (ARGB)

        if (this.itemStack != null) {
            context.drawItem(this.itemStack, 168 - this.width, 8);
        } else {
            TextureManager textureManager = client.getTextureManager();
            textureManager.bindTexture(iconTexture);
            context.drawTexture(iconTexture, 168 - this.width, 8, 0, 0, 16, 16, 16, 16);
        }

        context.drawText(client.textRenderer, this.title, 190 - this.width, 7, 0xFFFFFF, false);
        context.drawText(client.textRenderer, this.message, 190 - this.width, 18, 0xAAAAAA, false);

        float progress = (float) (delta - startTime) / duration;
        if (progress >= 1.0F) {
            return Visibility.HIDE;
        }

        int progressWidth = (int) (progress * (this.width - 4));
        int progressBarX = 160 - this.width;
        int progressBarY = this.getHeight() - 2;

        context.fill(progressBarX, progressBarY, progressBarX + progressWidth, this.getHeight(), this.progressColor);

        return Visibility.SHOW;
    }

    @Override
    public int getHeight() {
        return 32;
    }
}
