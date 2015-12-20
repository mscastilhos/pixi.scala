import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.RegExp

/** Pixi
  */
package object pixi {
  // Aliases
  type AbstractFilter = pixi.core.webgl.filters.Filter
  type SystemRenderer = pixi.core.Renderer
  type BaseTexture = pixi.core.BaseTexture
  type BlendMode = pixi.core.BlendMode
  type Circle = pixi.core.Circle
  type Container = pixi.core.Container
  type DisplayObject = pixi.core.DisplayObject
  type Ellipse = pixi.core.Ellipse
  type Graphics = pixi.core.Graphics
  type GraphicsData = pixi.core.GraphicsData
  type Matrix = pixi.core.Matrix
  type ParticleContainer = pixi.core.ParticleContainer
  type Point = pixi.core.Point
  type Polygon = pixi.core.Polygon
  type Rectangle = pixi.core.Rectangle
  type Renderer = pixi.core.Renderer
  type RenderTexture = pixi.core.RenderTexture
  type RoundedRectangle = pixi.core.RoundedRectangle
  type ScaleMode = pixi.core.ScaleMode
  type Shape = pixi.core.Shape
  type Sprite = pixi.core.Sprite
  type Text = pixi.core.Text
  type Texture = pixi.core.Texture
  type Ticker = pixi.core.Ticker
  type VideoBaseTexture = pixi.core.VideoBaseTexture
  val BaseTexture = pixi.core.BaseTexture
  val BlendMode = pixi.core.BlendMode
  val Matrix = pixi.core.Matrix
  val ParticleContainer = pixi.core.ParticleContainer
  val Rectangle = pixi.core.Rectangle
  val Renderer = pixi.core.Renderer
  val ScaleMode = pixi.core.ScaleMode
  val Shape = pixi.core.Shape
  val Sprite = pixi.core.Sprite
  val Text = pixi.core.Text
  val Texture = pixi.core.Texture
  val VideoBaseTexture = pixi.core.VideoBaseTexture

  type CanvasRenderer = pixi.core.canvas.CanvasRenderer
  type CanvasBuffer = pixi.core.canvas.utils.CanvasBuffer
  type CanvasGraphics = pixi.core.canvas.utils.CanvasGraphics
  type CanvasMaskManager = pixi.core.canvas.utils.CanvasMaskManager
  val CanvasTinter = pixi.core.canvas.utils.CanvasTinter

  type WebGLRenderer = pixi.core.webgl.WebGLRenderer
  type Filter = pixi.core.webgl.filters.Filter
  type FXAAFilter = pixi.core.webgl.filters.FXAAFilter
  type SpriteMaskFilter = pixi.core.webgl.filters.SpriteMaskFilter
  val Filter = pixi.core.webgl.filters.Filter

  type BlendModeManager = pixi.core.webgl.managers.BlendModeManager
  type FilterManager = pixi.core.webgl.managers.FilterManager
  type MaskManager = pixi.core.webgl.managers.MaskManager
  type ShaderManager = pixi.core.webgl.managers.ShaderManager
  type WebGLManager = pixi.core.webgl.managers.WebGLManager
  type WebGLMaskManager = pixi.core.webgl.managers.WebGLMaskManager

  type ComplexPrimitiveShader = pixi.core.webgl.shaders.ComplexPrimitiveShader
  type PrimitiveShader = pixi.core.webgl.shaders.PrimitiveShader
  type Shader = pixi.core.webgl.shaders.Shader
  type TextureShader = pixi.core.webgl.shaders.TextureShader

  type ObjectRenderer = pixi.core.webgl.utils.ObjectRenderer
  type Quad = pixi.core.webgl.utils.Quad
  type RenderTarget = pixi.core.webgl.utils.RenderTarget
  type StencilMaskStack = pixi.core.webgl.utils.StencilMaskStack

  type EventEmitter = pixi.eventemitter3.EventEmitter
  val EventEmitter = pixi.eventemitter3.EventEmitter

  type BitmapText = pixi.extras.BitmapText
  type MovieClip = pixi.extras.MovieClip
  type TilingSprite = pixi.extras.TilingSprite
  val BitmapText = pixi.extras.BitmapText
  val MovieClip = pixi.extras.MovieClip
  val TilingSprite = pixi.extras.TilingSprite

  type AsciiFilter = pixi.filters.AsciiFilter
  type BloomFilter = pixi.filters.BloomFilter
  type BlurDirFilter = pixi.filters.BlurDirFilter
  type BlurFilter = pixi.filters.BlurFilter
  type BlurXFilter = pixi.filters.BlurXFilter
  type BlurYFilter = pixi.filters.BlurYFilter
  type BlurYTintFilter = pixi.filters.BlurYTintFilter
  type ColorMatrixFilter = pixi.filters.ColorMatrixFilter
  type ColorStepFilter = pixi.filters.ColorStepFilter
  type ConvolutionFilter = pixi.filters.ConvolutionFilter
  type CrossHatchFilter = pixi.filters.CrossHatchFilter
  type DisplacementFilter = pixi.filters.DisplacementFilter
  type DotScreenFilter = pixi.filters.DotScreenFilter
  type DropShadowFilter = pixi.filters.DropShadowFilter
  type GrayFilter = pixi.filters.GrayFilter
  type InvertFilter = pixi.filters.InvertFilter
  type NoiseFilter = pixi.filters.NoiseFilter
  type NormalMapFilter = pixi.filters.NormalMapFilter
  type PixelateFilter = pixi.filters.PixelateFilter
  type RGBSplitFilter = pixi.filters.RGBSplitFilter
  type SepiaFilter = pixi.filters.SepiaFilter
  type ShockwaveFilter = pixi.filters.ShockwaveFilter
  type SmartBlurFilter = pixi.filters.SmartBlurFilter
  type TiltShiftAxisFilter = pixi.filters.TiltShiftAxisFilter
  type TiltShiftFilter = pixi.filters.TiltShiftFilter
  type TiltShiftXFilter = pixi.filters.TiltShiftXFilter
  type TiltShiftYFilter = pixi.filters.TiltShiftYFilter
  type TwistFilter = pixi.filters.TwistFilter

  type EventData = pixi.interaction.EventData
  type InteractionData = pixi.interaction.InteractionData
  type InteractiveTarget = pixi.interaction.InteractiveTarget

  type Loader = pixi.loaders.Loader
  type Resource = pixi.loaders.Resource
  val Loader = pixi.loaders.Loader

  type Mesh = pixi.mesh.Mesh
  type Rope = pixi.mesh.Rope
  val Mesh = pixi.mesh.Mesh

  /** The asset loader */
  val loader: Loader = g.PIXI.loader.asInstanceOf[Loader]

  /** String of the current PIXI version */
  val Version = g.PIXI.VERSION.asInstanceOf[String]

  /** Two Pi */
  val Pi_2: Double = g.PIXI.PI_2.asInstanceOf[Double]

  /** Constant conversion factor for converting radians to degrees */
  val RadToDeg: Double = g.PIXI.RAD_TO_DEG.asInstanceOf[Double]

  /** Constant conversion factor for converting degrees to radians */
  val DegToRad: Double = g.PIXI.DEG_TO_RAD.asInstanceOf[Double]

  /** Target frames per millisecond. */
  val TargetFpms: Double = g.PIXI.TARGET_FPMS.asInstanceOf[Double]

  /** The prefix that denotes a URL is for a retina asset */
  val RetinaPrefix: RegExp = g.PIXI.RETINA_PREFIX.asInstanceOf[RegExp]

  val Resolution: Int = g.PIXI.RESOLUTION.asInstanceOf[Int]

  val FilterResolution: Int = g.PIXI.FILTER_RESOLUTION.asInstanceOf[Int]

  val SpriteBatchSize: Int = g.PIXI.SPRITE_BATCH_SIZE.asInstanceOf[Int]
}
