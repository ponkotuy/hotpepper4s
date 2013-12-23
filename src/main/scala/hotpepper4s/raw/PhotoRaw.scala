package hotpepper4s.raw

import hotpepper4s.Photo.{PhotoMobile, PhotoPC}

/**
 * @author ponkotuy
 */
case class PhotoRaw(pc: PhotoPC, mobile: Option[PhotoMobile])
