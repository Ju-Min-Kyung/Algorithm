def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = []
    w = 0
    while truck_weights:
        if len(bridge) == bridge_length:
            w -= bridge.pop(0)
        
        
        cnt = truck_weights[0]
        if cnt <= weight - w:
            truck = truck_weights.pop(0)
            bridge.append(truck)
            w += truck
        else:
            bridge.append(0)
        answer += 1
    answer += bridge_length
    return answer