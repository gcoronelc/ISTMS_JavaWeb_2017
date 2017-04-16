/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.eurekaapp.controller;

import pe.egcc.appeureka.service.CuentaService;

/**
 *
 * @author Manuel Seoane
 */
public class CuentaController {
    
    private CuentaService cuentaService;

    public CuentaController() {
        cuentaService = new CuentaService();
    }
    
    public double conSaldo(String cuenta) {
        return cuentaService.conSaldo(cuenta);
    }
    
}
