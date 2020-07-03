package pl.tamides.tamides913

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class RoundedProgressBarWithTextInside(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    var text: String = "Text"
        set(value) {
            field = value
            calculateDimensions()
            invalidate()
        }
    var progress: Int = 35
        set(value) {
            field = value
            calculateDimensions()
            invalidate()
        }

    private var viewWidth = 0f
    private var viewHeight = 0f
    private var minViewWidth = 0
    private var minViewHeight = 0
    private var frameThikness: Float
    private var framePaint: Paint
    private var frameLeft = 0f
    private var frameTop = 0f
    private var frameRight = 0f
    private var frameBottom = 0f
    private var textHeight: Float
    private var textPadding: Float
    private var textPaint: Paint
    private var textWidth = 0f
    private var textX = 0f
    private var textY = 0f
    private var progressBackgroundPaint: Paint
    private var progressPaint: Paint
    private var progressLeft = 0f
    private var progressTop = 0f
    private var progressRight = 0f
    private var progressBottom = 0f

    init {
        val resources = context.resources
        val blackColor = resources.getColor(R.color.black, null)

        progressBackgroundPaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = resources.getColor(R.color.white, null)
        }

        progressPaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = resources.getColor(R.color.green, null)
        }

        frameThikness = resources.getDimension(R.dimen.line)
        framePaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = blackColor
            strokeWidth = frameThikness
            style = Paint.Style.STROKE
        }

        textHeight = resources.getDimension(R.dimen.small_text)
        textPadding = resources.getDimension(R.dimen.small_padding)
        textPaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = blackColor
            textSize = textHeight
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width = when (MeasureSpec.getMode(widthMeasureSpec)) {
            MeasureSpec.AT_MOST -> {
                min(minViewWidth, widthSize)
            }
            MeasureSpec.EXACTLY -> {
                widthSize
            }
            MeasureSpec.UNSPECIFIED -> {
                minViewWidth
            }
            else -> 0
        }

        val height = when (MeasureSpec.getMode(heightMeasureSpec)) {
            MeasureSpec.AT_MOST -> {
                min(minViewHeight, heightSize)
            }
            MeasureSpec.EXACTLY -> {
                heightSize
            }
            MeasureSpec.UNSPECIFIED -> {
                minViewHeight
            }
            else -> 0
        }

        setMeasuredDimension(width, height)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w.toFloat()
        viewHeight = h.toFloat()

        calculateDimensions()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRoundRect(
            frameLeft,
            frameTop,
            frameRight,
            frameBottom,
            textPadding,
            textPadding,
            progressBackgroundPaint
        )
        canvas?.drawRoundRect(
            progressLeft,
            progressTop,
            progressRight,
            progressBottom,
            textPadding,
            textPadding,
            progressPaint
        )
        canvas?.drawRoundRect(
            frameLeft,
            frameTop,
            frameRight,
            frameBottom,
            textPadding,
            textPadding,
            framePaint
        )
        canvas?.drawText(text, textX, textY, textPaint)
    }

    private fun calculateDimensions() {
        textWidth = textPaint.measureText(text)

        minViewWidth = (2 * frameThikness + 2 * textPadding + textWidth).toInt()
        minViewHeight = (2 * frameThikness + 2 * textPadding + textHeight).toInt()

        progressLeft = frameThikness
        progressTop = frameThikness
        progressRight = (viewWidth - frameThikness) * progress / 100
        progressBottom = viewHeight - frameThikness

        frameLeft = frameThikness
        frameTop = frameThikness
        frameRight = viewWidth - frameThikness
        frameBottom = viewHeight - frameThikness

        textX =
            (viewWidth - 2 * frameThikness - 2 * textPadding - textWidth) / 2 + frameThikness + textPadding
        textY = viewHeight / 2 - (textPaint.ascent() + textPaint.descent()) / 2
    }
}