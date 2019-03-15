//
//  FirstViewController.swift
//  ios
//
//  Created by Alexandre Gherschon on 14/03/2019.
//  Copyright © 2019 Alexandre Gherschon. All rights reserved.
//

import UIKit
import Analytics

class FirstViewController: UIViewController {
        
    private let eventsHelper: EventsHelper = EventsHelper.init()
    
    override func viewDidAppear(_ animated: Bool) {
        eventsHelper.enterScreen(screen: Screen.home)
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        eventsHelper.exitScreen(screen: Screen.home)
    }

}

