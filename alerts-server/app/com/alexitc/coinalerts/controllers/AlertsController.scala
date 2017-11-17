package com.alexitc.coinalerts.controllers

import javax.inject.Inject

import com.alexitc.coinalerts.models.{Alert, CreateAlertModel}
import com.alexitc.coinalerts.services.AlertService
import com.alexitc.play.tracer.PlayRequestTracing

class AlertsController @Inject() (
    components: JsonControllerComponents,
    alertService: AlertService)
    extends JsonController(components)
    with PlayRequestTracing {

  def create() = async[CreateAlertModel, Alert](Created) { (userId, model) =>
    alertService.create(model, userId)
  }
}